package com.example.pinterest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class PinterestApplication {

	public static void main(String[] args) {
		SpringApplication.run(PinterestApplication.class, args);
	}

}
