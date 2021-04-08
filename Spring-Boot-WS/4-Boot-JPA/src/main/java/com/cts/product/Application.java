package com.cts.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cts.product.entity.Product;
import com.cts.product.service.ProductService;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ApplicationContext ac = SpringApplication.run(Application.class, args);

		ProductService ps = ac.getBean(ProductService.class);

		Product prod = new Product();
		prod.setName("iPhone 12 Pro Max");
		prod.setPrice(139000);
		prod.setDescription("256 GB Blue");

		//ps.save(prod);
		
	/*
		ps.findAll().forEach(product->{
			System.out.println(product.getId());
			System.out.println(product.getName());
			System.out.println(product.getPrice());
			System.out.println(product.getDescription());
			System.out.println("--------------------------------");
		});
		 * 
		 */

		Product product = ps.findById(3);
		if (product != null) {
			System.out.println(product.getId());
			System.out.println(product.getName());
			System.out.println(product.getPrice());
			System.out.println(product.getDescription());
			System.out.println("--------------------------------");
		} else {
			System.out.println("Product ID not found");
		}

	}

}
