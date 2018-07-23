package com.java;

import org.omg.Messaging.SyncScopeHelper;

public class Bag {
	public static void main(String[] args) {
		Bag bag1 = new Bag();
		Bag bag2 = new Bag();
		System.out.println("1");
		try {
			synchronized (bag1) {
				bag1.wait(3000);
			} 
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("2");
	}
}
