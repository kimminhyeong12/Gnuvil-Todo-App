package com.gnuvil.todo_list;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TodoListApplication {

	public static void main(String[] args) {
		SpringApplication.run(TodoListApplication.class, args);
	}

	@Bean
	CommandLineRunner checkEnv() {
		return args -> {
			System.out.println("DATABASE_URL = " + System.getenv("DATABASE_URL"));
			System.out.println("DATABASE_USERNAME = " + System.getenv("DATABASE_USERNAME"));
			System.out.println("DATABASE_DRIVER = " + System.getenv("DATABASE_DRIVER"));
		};
	}


}
