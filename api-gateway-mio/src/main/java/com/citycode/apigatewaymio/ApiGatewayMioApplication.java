package com.citycode.apigatewaymio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ApiGatewayMioApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayMioApplication.class, args);
	}

}
