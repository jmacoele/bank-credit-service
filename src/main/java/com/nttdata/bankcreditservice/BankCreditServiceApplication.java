package com.nttdata.bankcreditservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class BankCreditServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankCreditServiceApplication.class, args);
	}

}
