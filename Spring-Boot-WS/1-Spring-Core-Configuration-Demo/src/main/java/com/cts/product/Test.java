package com.cts.product;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.cts.product.config.AppConfig;
import com.cts.product.service.ProductServiceImpl;

public class Test {

	public static void main(String[] args) {
		
		ApplicationContext ac=new AnnotationConfigApplicationContext(AppConfig.class);
		
		ProductServiceImpl ps1 = ac.getBean(ProductServiceImpl.class);
		ProductServiceImpl ps2 = ac.getBean(ProductServiceImpl.class);
		ProductServiceImpl ps3 = ac.getBean(ProductServiceImpl.class);
		
		

		
	}

}
