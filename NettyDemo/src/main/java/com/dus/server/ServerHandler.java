package com.dus.server;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class ServerHandler extends ChannelInboundHandlerAdapter{

	@Override
	public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
		System.out.println("channel registered ----------");
	}

	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		System.out.println("channel active ----------");
	}

//	@Override
//	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
//		
//		System.out.println("channel read ----------" + msg);
//	}

}
