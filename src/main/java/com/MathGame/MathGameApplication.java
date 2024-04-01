package com.MathGame;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
@ComponentScan(basePackages = "com.MathGame")
@EntityScan(basePackages = "com.MathGame.Entities")
public class MathGameApplication {

	public static void main(String[] args) {
		SpringApplication.run(MathGameApplication.class, args);
	}

}
