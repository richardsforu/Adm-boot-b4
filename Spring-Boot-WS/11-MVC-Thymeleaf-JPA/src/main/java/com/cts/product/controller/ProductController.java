package com.cts.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cts.product.dao.ProductDao;
import com.cts.product.entity.Product;

@Controller
public class ProductController {
	
	@Autowired
	private ProductDao prodDao;

	@RequestMapping("/")
	public String welcome() {
		return "index";
	}

	@RequestMapping("/loadProductForm")
	public String loadForm() {
		return "product-form";
	}

	@RequestMapping("/saveProduct")
	public String saveProduct(@ModelAttribute Product product) {
		System.out.println(">>>> saveProduct methd <<<<");
		
		prodDao.save(product);
		
		return "redirect:/listAllProducts";
	}
	
	@RequestMapping("/listAllProducts")
	public String listAllProducts(ModelMap mp) {
		
		mp.addAttribute("products",prodDao.findAll());
		
		return "products";
	}
	
	
	
	
	
	
	
	
	
	

}
