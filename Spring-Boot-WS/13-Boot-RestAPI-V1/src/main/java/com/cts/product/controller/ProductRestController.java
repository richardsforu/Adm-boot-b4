package com.cts.product.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.product.model.Product;

@RestController
@RequestMapping("/api/products")
@CrossOrigin
public class ProductRestController {

	Product p1 = new Product(1, "Book", "100 Pages", 234);
	Product p2 = new Product(2, "Pen", "Ball Pen", 34);
	Product p3 = new Product(3, "Usb", "Sony USB", 1500);
	Product p4 = new Product(4, "Mobile", "Samsung S21 Ultra", 124000);
	Product p5 = new Product(5, "Laptop", "Dell", 69000);
	
	
	/*
	 * 
	 *     User
	 *     -----
	 *     id	name
	 *     ------------
	 *     u1	Praveen
	 *     u2	James
	 *     u3	Kavya
	 *     
	 *     Reviews
	 *     ---------
	 *     rid	pid	comments	user
	 *     R001	1	Good		u1
	 *     R002	2	Bad			u2
	 *     R003 1	Okay		u3
	 *     R004	3	Suer		u1
	 *     
	 *     ------------------------------------
	 *     
	 *     Question:: List all reviews given by u1
	 *     Ex: http://localhost:8080/api/products/reviews/u1
	 *     	
	 * 
	 * 
	 * 
	 * 
	 */

	List<Product> prods = new ArrayList<>();
	
	
	@GetMapping
	public List<Product> findAll(){
		return prods;
	}

	@GetMapping("/add")
	public List<Product> f1() {
		prods.add(p1);
		prods.add(p2);
		prods.add(p3);
		prods.add(p4);
		prods.add(p5);

		return prods;
	}

	@GetMapping("/{id}")
	public Product f2(@PathVariable int id) {

		System.out.println(">>>>> ID::: " + id + " <<<<<<");
		Product prod = prods.stream().filter(product -> product.getId() == id).findFirst().orElse(null);
		return prod;
	}

	@GetMapping("/byName/{name}")
	public List<Product> findByName(@PathVariable String name) {
		System.out.println(">>>> Name:: " + name);
		return prods.stream().filter(product -> product.getName().trim().contains(name)).collect(Collectors.toList());
	}

	@GetMapping("/s2")
	public List<Product> f3() {
		return Arrays.asList(p1, p2, p3, p4, p5);
	}
	
	
	@PostMapping
	public List<Product> save(@RequestBody Product product){
		
		product.setId(prods.size()+1);
		prods.add(product);
		
		return prods;
	}
	
	
	
	
	
	

}
