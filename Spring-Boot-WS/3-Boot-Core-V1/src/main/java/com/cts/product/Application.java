package com.cts.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;

import com.cts.product.service.ProductService;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ApplicationContext ac= SpringApplication.run(Application.class, args);
		
		ProductService ps1 = ac.getBean(ProductService.class);
		ProductService ps2 = ac.getBean(ProductService.class);

		ps1.save();
		ps2.save();
	}

}
