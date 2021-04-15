package com.cts.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cts.product.dao.ProductDao;
import com.cts.product.entity.Product;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ApplicationContext ac=  SpringApplication.run(Application.class, args);
		
		ProductDao prodDao = ac.getBean(ProductDao.class);
		Product prod=new Product();
		prod.setId(1024);
		prod.setName("USB Drive");
		prod.setPrice(5000);
		prod.setDescription("Sony USB Drive 3.1");
		
		prodDao.save(prod);
		
		
		
		
	}

}
