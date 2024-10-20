package com.pharmaconnect;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "com.pharmaconnect.model")
public class PharmaConnect360Application {

	public static void main(String[] args) {
		SpringApplication.run(PharmaConnect360Application.class, args);
	}

}
