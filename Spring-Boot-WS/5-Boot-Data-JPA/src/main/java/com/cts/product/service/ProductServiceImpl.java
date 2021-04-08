package com.cts.product.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.product.dao.ProductDao;
import com.cts.product.entity.Product;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDao prodDao;

	@Override
	public Product save(Product product) {
		return prodDao.save(product);
	}

	@Override
	public List<Product> saveAllProducts(List<Product> products) {
		return prodDao.saveAll(products);
	}

	@Override
	public List<Product> findAll() {
		return prodDao.findAll();
	}

	@Override
	public Product findById(int id) {
		return prodDao.findById(id).orElse(null);
	}

	@Override
	public void deleteProduct(int id) {
		Product prod = findById(id);
		if (prod != null) {
			prodDao.delete(prod);
		}
	}

}
