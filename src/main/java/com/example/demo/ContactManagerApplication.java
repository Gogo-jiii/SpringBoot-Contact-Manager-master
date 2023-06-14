package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.example.demo", 
"com.example.demo.dao", "com.example.demo.controller", "com.example.demo.models", 
"com.example.demo.config"} )
public class ContactManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ContactManagerApplication.class, args);

		System.out.println("Server started...");
	}

}
