package com.cts.product.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cts.product.entity.Product;

@Repository
public class ProductDaoImpl implements ProductDao {

	@Autowired
	private EntityManager em;

	@Override
	public void save(Product product) {
		em.persist(product);
	}

	@Override
	public List<Product> findAll() {
		return em.createQuery("from Product").getResultList();
	}

	@Override
	public Product findById(int id) {
		return em.find(Product.class, id);
	}

	@Override
	public void delete(int id) {
		em.remove(findById(id));
	}

}
