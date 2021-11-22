package com.wolken.userTicketProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication

@ComponentScan("com.wolken.userTicketProject")
public class UserTicketProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserTicketProjectApplication.class, args);
	}

}
