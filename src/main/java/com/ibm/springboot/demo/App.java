package com.ibm.springboot.demo;

import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ch.qos.logback.classic.Logger;

@SpringBootApplication
public class App {

	private static final Logger LOG = (Logger) LoggerFactory.getLogger(App.class);

	public static void main(String[] args) {
		LOG.info("Starting...");
		SpringApplication.run(App.class, args);
		LOG.info("Started.");

}
}
