package com.froxy152.resilincepatterns.retry;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.retry.annotation.EnableRetry;

@EnableRetry
@SpringBootApplication
public class RetryApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(RetryApplication.class, args);
		RetryService service = context.getBean(RetryService.class);
		service.someAction();
	}


}
