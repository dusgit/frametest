package com.exa.common.tools.test;

import java.util.NoSuchElementException;

import org.apache.commons.pool2.ObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPool;

public class DogMain {
	public static void main(String[] args) {
		ObjectPool<Dog>pool = new GenericObjectPool<Dog>(new DogFactory());
		try {
			Dog dog = pool.borrowObject();
			dog.call("I am dog , this is my brother john.");
		} catch (NoSuchElementException e) {
			System.out.println("异常----没有对象");
		} catch (IllegalStateException e) {
			System.out.println("异常----对象非法");
		} catch (Exception e) {
			System.out.println("异常----其他异常");
			e.printStackTrace();
		}finally{
			pool.close();
		}
	}
}
