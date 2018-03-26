package com.frontendforresume_fc.demo;

import it.ozimov.springboot.mail.configuration.EnableEmailTools;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableEmailTools
public class FrontEndForResumeFcApplication {

	public static void main(String[] args) {
		SpringApplication.run(FrontEndForResumeFcApplication.class, args);
	}
}
