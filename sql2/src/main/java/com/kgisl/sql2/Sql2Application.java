package com.kgisl.sql2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;

@SpringBootApplication
@OpenAPIDefinition
public class Sql2Application {

	public static void main(String[] args) {
		SpringApplication.run(Sql2Application.class, args);
	}

}
