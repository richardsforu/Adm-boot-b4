package com.cts.product;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cts.product.model.Product;

@Controller
public class ProductConttroller {

	@RequestMapping(value = "/")
	public String welcome() {
		return "index";
	}

	@RequestMapping("/productForm")
	public String openForm() {
		return "form";
	}

	@RequestMapping("/saveProduct")
	public String saveProduct(
			@RequestParam("id") int id, 
			@RequestParam("name") String name,
			@RequestParam("price") double price, 
			@RequestParam("description") String description,ModelMap mp) {
		
		Product prod=new Product();
		prod.setId(id);
		prod.setDescription(description);
		prod.setName(name);
		prod.setPrice(price);
		
		mp.addAttribute("product",prod);
		
		System.out.println(">> ID: " + id);
		System.out.println(name);
		System.out.println(price);
		System.out.println(description);
		System.out.println(">>>>>> product is saved <<<<<<<");

		return "one";
	}

	
	@RequestMapping("/saveProductV1")
	public String saveproductV1(@ModelAttribute Product prod) {
		
		System.out.println(">>>> Save V1 <<<< ");
		System.out.println(prod.getStore().getStoreName());
		System.out.println(prod.getStore().getQuantity());
		
		return "one";
	}
	
	
	
	
	
	@RequestMapping(value = "/s1")
	public String f1(ModelMap mp) {
		System.out.println(">>>> ProductConttroller f1 method .. <<<<<");
		mp.addAttribute("user", "Praveen");
		return "one";
	}

}
