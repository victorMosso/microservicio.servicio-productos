package com.udemy.ms.springboot.app.productos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
@EntityScan(basePackages = {"com.udemy.ms.springboot.model.commons.entity"})
public class SpringbootMicroServProductosApp {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootMicroServProductosApp.class, args);
	}

}
