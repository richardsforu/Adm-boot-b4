package com.cts.product.service;

import java.util.List;

import com.cts.product.entity.Product;

public interface ProductService {

	Product save(Product product);

	List<Product> saveAllProducts(List<Product> products);

	List<Product> findAll();

	Product findById(int id);

	void deleteProduct(int id);

	List<Product> findByNameLike(String name);
	
	
}