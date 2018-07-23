package com.dus.client;

import com.dus.frame.Chat;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.serialization.ClassResolvers;
import io.netty.handler.codec.serialization.ObjectDecoder;
import io.netty.handler.codec.serialization.ObjectEncoder;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

public class NettyClient implements Runnable{
	
	private static int port = 9900;
	public static ChannelFuture cf;
	

	public void startClient(){
		
	}
	
	public static void main(String[] args) {
		NettyClient nc = new NettyClient();
		Thread t = new Thread(nc);
		t.start();
	}

	@Override
	public void run() {
		//初始化界面
		Chat chat = new Chat();
		chat.initChat();
		// 启动连接
		cf = null;
		Bootstrap bs = new Bootstrap();
		EventLoopGroup elg = new NioEventLoopGroup();
		bs.group(elg)
		  .channel(NioSocketChannel.class)
		  .handler(new ChannelInitializer<Channel>() {
			@Override
			protected void initChannel(Channel ch) throws Exception {
				ch.pipeline().addLast(new ObjectDecoder(1024 >> 2, ClassResolvers.cacheDisabled(getClass().getClassLoader())));
                ch.pipeline().addLast(new ObjectEncoder());
                ch.pipeline().addLast(new ClientObjectHandler());
                
//				ch.pipeline().addLast(new StringDecoder());
//				ch.pipeline().addLast(new StringEncoder());
//				ch.pipeline().addLast(new ClientHandler());
//				ch.pipeline().addLast(new ClientHandler2());
			}
		});
		try {
			cf = bs.connect("127.0.0.1", port).sync();
			cf.channel().closeFuture().sync();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally{
			elg.shutdownGracefully();
		}
	}
}
