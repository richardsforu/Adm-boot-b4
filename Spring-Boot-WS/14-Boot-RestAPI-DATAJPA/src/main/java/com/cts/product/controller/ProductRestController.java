package com.cts.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.product.entity.Product;
import com.cts.product.service.ProductService;

@RestController
@RequestMapping("/api/products")
@CrossOrigin
public class ProductRestController {

	@Autowired
	private ProductService ps;

	// list all products
	@GetMapping
	public List<Product> findAllProducts() {
		return ps.findAll();
	}

	// Find Product By Product ID
	@GetMapping("/{id}")
	public Product findProductById(@PathVariable int id) {
		return ps.findById(id);
	}

	// filter products by product name
	@GetMapping("/byName/{name}")
	public List<Product> findAllProductsByName(@PathVariable String name) {
		return ps.findByNameLike(name);
	}

	// save a single product
	@PostMapping
	public Product save(@RequestBody Product product) {
		return ps.save(product);
	}

	// save all products
	@PostMapping("/saveAll")
	public List<Product> saveAllProducts(@RequestBody List<Product> products) {
		return ps.saveAllProducts(products);
	}

	// delete product by ID
	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable int id) {
		ps.deleteProduct(id);
	}

	// save a single product
	@PutMapping
	public Product update(@RequestBody Product product) {
		return ps.save(product);
	}

}
