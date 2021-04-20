package com.cts.product.conttroller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/api/products")
public class ProducttRestController {
	
	@GetMapping
	public String f1() {
		return "GET method from speing side...";
	}
	
	
	@PostMapping
	public String f2() {
		return "Welcome to Spring rest Aplication:: POST";
	}
	
	@PutMapping
	public String f3() {
		return "Welcome to Spring rest Aplication:: PUT";
	}
	
	
	@PatchMapping
	public String f4() {
		return "Welcome to Spring rest Aplication:: PATCH";
	}
	
	@DeleteMapping
	public String f5() {
		return "Welcome to Spring rest Aplication:: DELETE";
	}

}
