package com.dus.demo1;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

public class Server implements Runnable {

	@Override
	public void run() {
		NioEventLoopGroup parentGroup = new NioEventLoopGroup(1);
		NioEventLoopGroup childGroup = new NioEventLoopGroup();

		// 组装服务端
		ServerBootstrap sbs = new ServerBootstrap()
				.channel(NioServerSocketChannel.class)
				.group(parentGroup, childGroup)
				.handler(new ServerHandler1())
				.childHandler(new ChannelInitializer<Channel>() {
					@Override
					protected void initChannel(Channel ch) throws Exception {
						ch.pipeline().addLast(new ServerHandler2());
					}
				});
		// 启动服务端
		try {
			ChannelFuture cf = sbs.bind("localhost", 9900).sync();
			cf.channel().closeFuture().sync();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			parentGroup.shutdownGracefully();
			childGroup.shutdownGracefully();
		}
	}

	public class ServerHandler1 extends ChannelInboundHandlerAdapter {
		@Override
		public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
			System.out.println("server handler1 register ---- ---- ");
			super.channelRegistered(ctx);
		}
		@Override
		public void channelActive(ChannelHandlerContext ctx) throws Exception {
			System.out.println("server handler1 active ---- ---- ");
			super.channelActive(ctx);
		}
		@Override
		public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
			System.out.println("server handler1 read ---- ---- ");
			ctx.pipeline().writeAndFlush(msg);
			super.channelRead(ctx, msg); 
		}
	}
	
	public class ServerHandler2 extends ChannelInboundHandlerAdapter {
		@Override
		public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
			System.out.println("server handler2 register ---- ---- ");
			super.channelRegistered(ctx);
		}
		@Override
		public void channelActive(ChannelHandlerContext ctx) throws Exception {
			System.out.println("server handler2 active ---- ---- ");
			super.channelActive(ctx);
		}
		@Override
		public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
			System.out.println("server handler2 read ---- ---- ");
			ctx.pipeline().writeAndFlush(msg);
			super.channelRead(ctx, msg);
		}
	}

	public static void main(String[] args) {
		new Thread(new Server()).start();
	}
}
