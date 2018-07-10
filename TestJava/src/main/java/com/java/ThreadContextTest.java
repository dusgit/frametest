package com.java;

public class ThreadContextTest {

	public static int count = 10000000;
	public static String a = "";
	public static String b = "";
	public static String c = "";
	public static String d = "";
	public static String m = "我";
	
	public static void runSingleThread(){
		long start = System.currentTimeMillis();
		for (int i=0;i<count;i++){
			c += m;
			if(c.length() > 10){
				c = "";
			}
		}
		for(int i=0;i<count;i++){
			d += m;
			if(d.length() > 10){
				d = "";
			}
		}
		long end = System.currentTimeMillis();
		System.out.println("c:"+c+",d:"+d+".串行-总计耗时："+(end - start)+"毫秒");
	}
	
	public static void runMoreThread(){
		Thread t = new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i=0;i<count;i++){
					a += m;
					if(a.length() > 10){
						a = "";
					}
				}
				
			}
		});
		long start = System.currentTimeMillis();
		t.start();
		for(int i=0;i<count;i++){
			b += m;
			if(b.length() > 10){
				b = "";
			}
		}
		try {t.join();} catch (InterruptedException e) {e.printStackTrace();}
		long end = System.currentTimeMillis();
		System.out.println("a:"+a+",b:"+b+".并发-总计耗时："+(end - start)+"毫秒");
	}
	
	public static void main(String[] args) {
		for(int i=0;i<10;i++){
			runMoreThread();
			runSingleThread();
		}
		// 并行耗时更多，因为有上下文切换
	}
}
