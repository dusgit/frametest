package com.dus.client;

import com.dus.interfaces.Animal;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class ClientObjectHandler extends ChannelInboundHandlerAdapter {

	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
//		System.out.println("client channel active");
//		ctx.write("1");
//		ctx.flush();
	}

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		System.out.println("---------- client read");
//		Animal dog = (Animal)msg;
//		System.out.println("client : 线程名称:" + Thread.currentThread().getName());
//		dog.call("asdfasd");
//		System.out.println("---------"+msg);
	}
	
}
