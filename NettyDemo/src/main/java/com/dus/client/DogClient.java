package com.dus.client;

import com.dus.interfaces.Animal;

public class DogClient implements Animal {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1855174979622164381L;

	@Override
	public void call(String con) {
		System.out.println("client animal " + con);

	}

}
