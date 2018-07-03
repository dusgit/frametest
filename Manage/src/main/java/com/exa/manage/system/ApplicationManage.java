package com.exa.manage.system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;

@SpringBootApplication
@EnableDubboConfiguration
@ComponentScan("com.exa.manage")
@ImportResource(locations= {"classpath:spring-dubbo.xml"})
public class ApplicationManage {
	public static void main(String[] args) {
		SpringApplication.run(ApplicationManage.class, args);
	}
}
