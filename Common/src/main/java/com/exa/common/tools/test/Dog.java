package com.exa.common.tools.test;

public class Dog {
	private String name;
	private boolean isActive = false;
	public String call(String msg){
		if(isActive){
			System.out.println(msg);
			return msg;
		}else{
			System.out.println("dog is died");
			return "dog is died";
		}
	}
	
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	
	
}
