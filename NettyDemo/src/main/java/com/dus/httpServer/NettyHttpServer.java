package com.dus.httpServer;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpRequestDecoder;
import io.netty.handler.codec.http.HttpResponseEncoder;
import io.netty.handler.stream.ChunkedWriteHandler;

public class NettyHttpServer implements Runnable{
	
	public static int port = 9099; // 监听端口

	@Override
	public void run() {
		
		NioEventLoopGroup parentGroup = new NioEventLoopGroup(1);
		NioEventLoopGroup childGroup = new NioEventLoopGroup(1);
		
		ServerBootstrap sbs = new ServerBootstrap()
				.group(parentGroup, childGroup)
				.channel(NioServerSocketChannel.class)
				.childHandler(new ChannelInitializer<Channel>() {
					@Override
					protected void initChannel(Channel ch) throws Exception {
						ch.pipeline().addLast("http-decode",new HttpRequestDecoder());       // http解码
						ch.pipeline().addLast("aggregator",new HttpObjectAggregator(65536)); // 聚合
						ch.pipeline().addLast("http-encoder", new HttpResponseEncoder());    // http编码
						ch.pipeline().addLast("http-chunked",new ChunkedWriteHandler());     // 支持异步发送大的码流,但不占用过多的内存,防止JAVA内存溢出
						ch.pipeline().addLast("httpServerHandler", new ServerHttpHandler());
					}
				});
		
		try {
			ChannelFuture cf = sbs.bind("localhost", port).sync();
			System.out.println("web start on " + port);
			cf.channel().closeFuture().sync();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally{
			parentGroup.shutdownGracefully();
			childGroup.shutdownGracefully();
		}
	}
	
	public static void main(String[] args) {
		new Thread(new NettyHttpServer()).start();
	}
}
