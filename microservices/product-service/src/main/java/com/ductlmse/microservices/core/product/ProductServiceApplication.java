package com.ductlmse.microservices.core.product;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.ductlmse")
public class ProductServiceApplication {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(ProductServiceApplication.class);


	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(ProductServiceApplication.class, args);
		String mongoHost = context.getEnvironment().getProperty("spring.data.mongodb.host");
		String mongoPort = context.getEnvironment().getProperty("spring.data.mongodb.port");
		LOGGER.info("Mongo host: {} : {}", mongoHost, mongoPort);
	}

}
