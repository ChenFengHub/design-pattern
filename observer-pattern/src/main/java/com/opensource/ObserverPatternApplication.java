package com.opensource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
//@EnableAsync
public class ObserverPatternApplication {

	public static void main(String[] args) {
		SpringApplication.run(ObserverPatternApplication.class, args);
	}

}
