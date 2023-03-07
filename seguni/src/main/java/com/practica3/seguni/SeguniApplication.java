package com.practica3.seguni;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
@EntityScan("entity")
public class SeguniApplication {

	public static void main(String[] args) {
		SpringApplication.run(SeguniApplication.class, args);
	}

}
