package com.alissonpedrina;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.alissonpedrina")
public class LiquibaseappApplication {
	
    public static void main(String[] args) {
        SpringApplication.run(LiquibaseappApplication.class, args);
    }

}
