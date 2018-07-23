package com.dus.server;

import com.dus.interfaces.Animal;

public class DogServer implements Animal {

	@Override
	public void call(String con) {
		System.out.println(con);
	}

}
