package com.exa.client.system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ComponentScan("com.exa")
@ImportResource(locations= {"classpath:conf/spring-dubbo.xml"})
public class ApplicationClient {
	public static void main(String[] args) {
		SpringApplication.run(ApplicationClient.class, args);
	}
}
