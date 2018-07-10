package com.dus.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

public class NettyServer {
	
	private static int port = 9900;
	
	public void start(){
		EventLoopGroup parentGroup   = new NioEventLoopGroup(1);
		EventLoopGroup childGroup = new NioEventLoopGroup();
		
		ServerBootstrap sbs = new ServerBootstrap();
		sbs.group(parentGroup, childGroup)
		   .channel(NioServerSocketChannel.class)
		   .handler(new ServerHandler())
		   .childHandler(new ChannelInitializer<SocketChannel>() {
			@Override
			protected void initChannel(SocketChannel ch) throws Exception {
				ch.pipeline().addLast(new StringDecoder());
	            ch.pipeline().addLast(new StringEncoder());
				ch.pipeline().addLast(new ServerChildHandler());
			}  
		});
		System.out.println("server start at " + port);
		try {
			ChannelFuture cf = sbs.bind(port).sync();
			cf.channel().closeFuture().sync();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally{
			parentGroup.shutdownGracefully();
			childGroup.shutdownGracefully();
		}
		   
	}
	
	public static void main(String[] args) {
		NettyServer ns = new NettyServer();
		ns.start();
	}
	
}
