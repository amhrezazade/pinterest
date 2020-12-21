package com.example.pinterest;

import java.io.File;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


@SpringBootApplication
@EnableJpaAuditing
public class PinterestApplication {

	public static void main(String[] args) {
		
		try{
			File theDir = new File("target/Files");
			if (!theDir.exists()){
				theDir.mkdirs();
			}
		}
		catch(Exception ex){
			System.out.print("Directory creating error");
		}
		SpringApplication.run(PinterestApplication.class, args);
	}

}
