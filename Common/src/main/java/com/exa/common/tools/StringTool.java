package com.exa.common.tools;

public class StringTool {
	
	public static Integer getIntegerKey(Integer timeInt,Integer sera){
		return timeInt - timeInt%sera;
	}
	
	public static Integer getCurrentKey(Integer sera){
		Long nowLong = System.currentTimeMillis()/1000;
		Integer nowInt = nowLong.intValue();
		return nowInt - nowInt%sera;
	}
	
	public static void main(String[] args) {
		for(int i=0;i<10;i++){
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(getCurrentKey(5));
		}
	}
}
