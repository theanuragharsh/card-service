package com.banking.card;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;

@RefreshScope
@SpringBootApplication
public class CardServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CardServiceApplication.class, args);
	}

}
