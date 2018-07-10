package com.dus.server;

import java.util.HashMap;
import java.util.Map;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class ServerChildHandler extends ChannelInboundHandlerAdapter{
	
	public static Map<String,Channel> channelMap = new HashMap<String,Channel>();

	@Override
	public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
		System.out.println("server channel registered ----------");
	}

	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		//保存channel
		Channel channel = ctx.channel();
		channelMap.put(channel.id().toString(), channel);
		System.out.println("server channel active ----------");
	}

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		System.out.println("server channel read ----------" + msg);
		// 发送给相关人员
		for(String key:channelMap.keySet()){
			Channel channel = channelMap.get(key);
			if(!channel.id().equals(ctx.channel().id())){
				channel.writeAndFlush(ctx.channel().id() + ":"+msg);
			}
		}
		// ctx.channel().write(msg);
		// ctx.flush();
	}

}
