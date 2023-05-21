package com.bahadirmemis.akbankbootcamp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class AkbankBootcampApplication {

	public static void main(String[] args) {
		SpringApplication.run(AkbankBootcampApplication.class, args);
	}

}
