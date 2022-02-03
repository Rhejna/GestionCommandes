package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
public class GestComApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestComApplication.class, args);
	}

	@GetMapping
	public String hello(){
		return "UwU Gestion Commande ou whatever";
	}

}
