package com.cts.product.service;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

@Service
@Lazy
@Scope("prototype")
public class ProductServiceImpl {

	public ProductServiceImpl() {
		System.out.println("--- ProductServiceImpl class object created on "+System.identityHashCode(this));
	}

}
