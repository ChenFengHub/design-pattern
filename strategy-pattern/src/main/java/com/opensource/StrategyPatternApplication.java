package com.opensource;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.opensource.usedb")
public class StrategyPatternApplication {

	public static void main(String[] args) {
		SpringApplication.run(StrategyPatternApplication.class, args);
	}

}
