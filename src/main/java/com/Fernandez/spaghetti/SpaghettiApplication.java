package com.Fernandez.spaghetti;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpaghettiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpaghettiApplication.class, args);
	}

	@GetMapping("/")
	public String home() {
		return "Hola, ya funciona Spring Boot ";
	}
}