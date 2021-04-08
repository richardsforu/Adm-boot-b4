package com.cts.product.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.stereotype.Service;

import com.cts.product.dao.ProductDao;

@Service
@Scope("singleton")
public class ProductServiceImpl implements ProductService {
	
	public ProductServiceImpl() {
		System.out.println(">>>>> ProductServiceImpl object created on "+this.hashCode()+" Hashcode <<<<<");
	}

	@Value("${name}")
	private String personName;

	@Value("${age}")
	private int age; // primitives always auto wrapped by wrapper classes
	
	@Value("${dob}")
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate dob;

	@Autowired
	private ProductDao prodDao;

	@Override
	public void save() {
		System.out.println("ProductService:::: save using "+this.hashCode()+" hashcode");
		prodDao.save();
	}

	//@Bean
	public void f1() {
		System.out.println(">>>>> Name is " + personName);

		System.out.println(">>>>> DOB: " + dob);

		System.out.println(">>>>> Age::: " + age);
	}

}
