package com.woorinpang.settlementservice.application.settlement.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class SettlementApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SettlementApiApplication.class, args);
	}

}
