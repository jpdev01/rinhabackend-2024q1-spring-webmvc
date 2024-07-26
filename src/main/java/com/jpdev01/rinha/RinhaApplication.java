package com.jpdev01.rinha;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;

@SpringBootApplication
//@EnableR2dbcRepositories(basePackages = "com.jpdev01.rinha.repository")
public class RinhaApplication {

	public static void main(String[] args) {
		SpringApplication.run(RinhaApplication.class, args);
	}

}
