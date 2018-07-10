package com.dus.client;

import com.dus.frame.Chat;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class ClientHandler extends ChannelInboundHandlerAdapter {

	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		//System.out.println("client channel active");
		//ctx.write("1");
		//ctx.flush();
	}

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		if(msg.getClass() == String.class){
			System.out.println("我是字符串");
			Channel channel = ctx.channel();
			Chat.jTextArea.append(msg + "\n");
		}
	}
	
}
