package com.codefix.gitbuddy.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.codefix.gitbuddy.app"})
public class GitBuddyApplication {

	public static void main(String[] args) {
		SpringApplication.run(GitBuddyApplication.class, args);
	}

}
