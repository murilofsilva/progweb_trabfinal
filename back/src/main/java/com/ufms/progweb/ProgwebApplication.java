package com.ufms.progweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.ufms.progweb.repository")
public class ProgwebApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProgwebApplication.class, args);
	}

}