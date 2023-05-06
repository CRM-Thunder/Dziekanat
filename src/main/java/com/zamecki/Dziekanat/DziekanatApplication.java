package com.zamecki.Dziekanat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoRepositories
@SpringBootApplication
public class DziekanatApplication {

	public static void main(String[] args) {
		SpringApplication.run(DziekanatApplication.class, args);
	}

}
