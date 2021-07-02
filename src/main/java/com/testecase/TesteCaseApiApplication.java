package com.testecase;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class TesteCaseApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(TesteCaseApiApplication.class, args);
	}

}
