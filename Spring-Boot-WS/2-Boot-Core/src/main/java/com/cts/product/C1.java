package com.cts.product;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class C1 {

	public C1() {
		System.out.println("--- C1 class object created...");
	}

	
	public void f1() {
		System.out.println(">>>>>> C1 class f1 method");
	}
}
