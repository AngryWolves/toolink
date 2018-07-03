package com.angrywolves.tolink;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.context.request.RequestContextListener;

@SpringBootApplication
@EnableTransactionManagement
@ComponentScan(basePackages = "com.angrywolves")
public class ToLinkApplication {

	public static void main(String[] args) {
		SpringApplication.run(ToLinkApplication.class, args);
	}

	@Bean
	public RequestContextListener requestContextListener(){
		return new RequestContextListener();
	}
}
