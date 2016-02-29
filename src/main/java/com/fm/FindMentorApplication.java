package com.fm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
public class FindMentorApplication {

	public static void main(String[] args) {
		SpringApplication.run(FindMentorApplication.class, args);
	}
}
