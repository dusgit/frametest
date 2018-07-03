package com.exa.server.system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;

@SpringBootApplication
@ImportResource(locations= {"classpath:spring-db.xml"})
@EnableDubboConfiguration
public class ApplicationServer {
	public static void main(String[] args) {
		SpringApplication.run(ApplicationServer.class, args);
	}
}
