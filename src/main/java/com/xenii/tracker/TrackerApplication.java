package com.xenii.tracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TrackerApplication {

	//MUST BE RAN BEFORE FRONTEND
	public static void main(String[] args) {
		SpringApplication.run(TrackerApplication.class, args);
	}

}
