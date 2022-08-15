package com.disqo.bestnote;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
public class BestnoteApplication {

	public static void main(String[] args) {
		SpringApplication.run(BestnoteApplication.class, args);
	}

}
