package com.exa.common.tools;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.springframework.stereotype.Component;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

@Component
public class RedisTool {

	private static JedisPool jedisPool;
	
	public RedisTool(){
		initJedisPool();
	}
	
	public static void initJedisPool(){
		JedisPoolConfig jpc = new JedisPoolConfig();
		jedisPool = new JedisPool(jpc,"localhost");
	}
	
	public static String set(String name,String value){
		Jedis jedis = jedisPool.getResource();
		try{
			return jedis.set(name,value);
		}finally{
			jedis.close();
		}
	}
	public static String set(String name,String value,Integer seconds){
		Jedis jedis = jedisPool.getResource();
		try{
			return jedis.set(name,value);
		}finally{
			jedis.close();
		}
	}
	public static String get(String name){
		Jedis jedis = jedisPool.getResource();
		try{
			return jedis.get(name);
		}finally{
			jedis.close();
		}
	}
	
	public static boolean exist(String key){
		Jedis jedis = jedisPool.getResource();
		try{
			return jedis.exists(key);
		}finally{
			jedis.close();
		}
	}
	
	// 存对象  
    public static void setObject(String key, Object obj) throws Exception {  
        ObjectOutputStream oos = null;  //对象输出流  
        ByteArrayOutputStream bos = null;  //内存缓冲流  
        bos = new ByteArrayOutputStream();  
        oos = new ObjectOutputStream(bos);  
        oos.writeObject(obj);   
        byte[] byt = bos.toByteArray();  
        Jedis jedis = jedisPool.getResource();
        try{
        	jedis.set(key.getBytes(), byt);  
        }finally{
        	jedis.close();
        }
        bos.close();  
        oos.close();  
    }  
  
    // 取对象  
    public static Object getObject(String key) throws Exception {  
    	Jedis jedis = jedisPool.getResource();
        byte[] byt = jedis.get(key.getBytes());  
        jedis.close();
        ObjectInputStream ois = null;  //对象输入流  
        ByteArrayInputStream bis = null;   //内存缓冲流  
        Object obj = null;  
        bis = new ByteArrayInputStream(byt);  
        ois = new ObjectInputStream(bis);  
        obj = ois.readObject();  
        bis.close();  
        ois.close();  
        return obj;  
    }  
	
	public static void main(String[] args) {
		initJedisPool();
	}
}
