package com.dus.demo1;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

public class Client implements Runnable {

	@Override
	public void run() {
		// 组装
		NioEventLoopGroup group = new NioEventLoopGroup();
		Bootstrap bs = new Bootstrap()
				.channel(NioSocketChannel.class)
				.group(group)
				.handler(new ClientHandler());
		// 启动
		try {
			ChannelFuture cf = bs.connect("localhost", 9900).sync();
			cf.channel().closeFuture().sync();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally{
			group.shutdownGracefully();
		}
	}
	
	public class ClientHandler extends ChannelInboundHandlerAdapter{

		@Override
		public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
			System.out.println("client channel registered ---------");
			super.channelRegistered(ctx);
		}

		@Override
		public void channelActive(ChannelHandlerContext ctx) throws Exception {
			System.out.println("client channel active ---------");
			ctx.pipeline().writeAndFlush("2");
			//super.channelActive(ctx);
		}

		@Override
		public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
			System.out.println("client channel read ---------");
			ctx.channel().writeAndFlush(msg);
			//super.channelRead(ctx, msg);
		}
			
	}
	
	public static void main(String[] args) {
		new Thread(new Client()).start();
	}

}
