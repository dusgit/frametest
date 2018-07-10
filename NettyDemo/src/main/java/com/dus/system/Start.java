package com.dus.system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.dus")
public class Start {
	
	public static void main(String[] args) {
		SpringApplication.run(Start.class, args);
	}

}
