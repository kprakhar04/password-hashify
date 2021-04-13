package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;

@SpringBootApplication
public class PasswordHashingApplication {

	public static void main(String[] args) {
		SpringApplication.run(PasswordHashingApplication.class, args);
	}

	@Bean
	public BCryptPasswordEncoder bcryptEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public Pbkdf2PasswordEncoder pbkdf2Encoder() {
		return new Pbkdf2PasswordEncoder();
	}

	@Bean
	public SCryptPasswordEncoder scryptEncoder() {
		return new SCryptPasswordEncoder();
	}

}
