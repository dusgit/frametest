package com.dus.server;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class ServerObjectHandler extends ChannelInboundHandlerAdapter{

	@Override
	public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
		System.out.println("server object channel registered");
	}

	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		System.out.println("server object channel active");
	}

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		System.out.println("object channel : " + msg);
		DogServer dog = new DogServer();
		System.out.println("server : 线程名称:" + Thread.currentThread().getName());
//		ctx.channel().writeAndFlush(dog);
		ctx.channel().writeAndFlush(msg);
	}

}
