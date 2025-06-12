package com.sistemagym.gym;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GymApplication {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(GymApplication.class);
		String port = System.getenv("port");
		if (port != null) {
			app.setDefaultProperties(Collections.singletonMap("server.port", port));
		}
		app.run(args);
	}

}
