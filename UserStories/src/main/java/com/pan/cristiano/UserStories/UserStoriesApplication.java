package com.pan.cristiano.UserStories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.pan.cristiano.UserStories.Repo.IClienteRepository;

@SpringBootApplication
public class UserStoriesApplication {

	@Autowired
	public static void main(String[] args) {
		SpringApplication.run(UserStoriesApplication.class, args);
		
	}

}
