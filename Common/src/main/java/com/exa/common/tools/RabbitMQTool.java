package com.exa.common.tools;

import java.io.IOException;

import com.rabbitmq.client.BasicProperties;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;

public class RabbitMQTool {
	private static String userName = "guest";
	private static String password = "guest";
	private static String virtualHost = "/";
	private static String host = "127.0.0.1";
	private static int port = 5672;

	public static void main(String[] args) {
		producer();
	}
	
	public static void produceMsg(String msg){
		
	}
	
	// 生产者
	public static void producer() {
		// 实例化工厂
		ConnectionFactory factory = new ConnectionFactory();
		// 设置相关参数,地址，端口，账号，密码
		factory.setHost("127.0.0.1");
		factory.setPort(5672);
		factory.setUsername("guest");
		factory.setPassword("guest");
		try {
			// 获取connection
			Connection conn = factory.newConnection();
			// 获取channel
			Channel channel = conn.createChannel();
			// 创建队列 1-队列名称 2-队列是否持久化 3-是否是排他队列 4-使用完之后是否删除此队列 5-其他属性
			channel.queueDeclare("hello", false, false, false, null);
			// 创建路由 1-路由名称 2-路由类型
			// fanout:把所有发送到该Exchange的消息投递到所有与它绑定的队列中。
		    // direct:把消息投递到那些binding key与routing key完全匹配的队列中。
		    // topic:将消息路由到binding key与routing key模式匹配的队列中。
			channel.exchangeDeclare("myexchange", "topic");
			// 绑定路由队列 1-队列名称 2-路由名称 3-routing key
			channel.queueBind("hello", "myexchange", "shensha");
			// 发送消息 1-路由名称 2-routing key 3-其他信息 4-消息字节数组
			channel.basicPublish("myexchange", "shensha", null, "HelloWorld".getBytes());
			// 关闭资源
			channel.close();
			conn.close();
		} catch (Exception e) {

		} finally {

		}
	}

	// 消费者
	public static void consumer() {
		ConnectionFactory factory = new ConnectionFactory();
		// "guest"/"guest" by default, limited to localhost connections
		factory.setUsername(userName);
		factory.setPassword(password);
		factory.setVirtualHost(virtualHost);
		factory.setHost(host);
		factory.setPort(port);
		try {
			// 获取connection
			Connection conn = factory.newConnection();
			// 获取channel
			Channel channel = conn.createChannel();
			// 创建队列 1-队列名称 2-队列是否持久化 3-是否是排他队列 4-使用完之后是否删除此队列 5-其他属性
			channel.queueDeclare("hello", false, false, false, null);
			// 消费消息. 1-消费队列 2-是否自动发送消息回执 3-回调函数
			channel.basicConsume("hello", true, new DefaultConsumer(channel) {
				public void handleDelivery(String consumerTag, Envelope envelope, BasicProperties properties,
						byte[] body) throws IOException {
					String message = new String(body, "UTF-8");
					System.out.println("接收到的消息为: " + message);
				}

			});
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
