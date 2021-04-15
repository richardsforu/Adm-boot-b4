package com.cts.product.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cts.product.model.Product;

@Controller
public class ProductController {

	// without view and model
	@RequestMapping("/s1")
	public void f1() {
		// model means business logic
		System.out.println(">>>>>>>>>>> ProductController f1 method <<<<<<<<<");
	}

	// with View ... JSP and without model
	@RequestMapping("/s2")
	public String f2() {

		System.out.println(">>>>>>>>>>> ProductController f2 method <<<<<<<<<");

		return "one"; // name of jsp in WEB-INF/views folder
	}

	// with model and view - v1
	// Model is a interface used to store Java objects as key and value pares in
	// request object
	@RequestMapping(value = "/s3")
	public String f3(Model model) {
		String userName = "Praveen";
		model.addAttribute("user", userName);
		model.addAttribute("city", "Hyderabad");
		System.out.println(">>>>>>>>>>> ProductController f3 method <<<<<<<<<");
		return "two";

	}

	// with Model and View - v2 - old approach - ModelAndView class
	@RequestMapping("/s4")
	public ModelAndView f4() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("two");
		mav.addObject("user", "Admin");
		mav.addObject("city", "Pune");
		return mav;
	}
	
	
	// with Model And View - v3
	@RequestMapping("/s5")
	public String f5(ModelMap mp) {
		
		mp.addAttribute("city","Kolkata");
		mp.addAttribute("user","James");
		
		return "two";
		
	}
	
	
	// WITH ModelandView -v4
	@RequestMapping("/s6")
	public String f6(ModelMap mp) {
		
		Product p1=new Product(10, "Pen", 76, "Red Ink");
		Product p2=new Product(11, "Book", 108, "White Pages");
		Product p3=new Product(12, "Usb", 1500, "256 GB");
		Product p4=new Product(13, "Mobile", 25000, "Samsung A7");
		Product p5=new Product(14, "Laptop", 96000, "HP Laptop I7 ");
		
		List<Product> products=Arrays.asList(p1,p2,p3,p4,p5);

		
		mp.addAttribute(p1); // type of productObject is Product class
		mp.addAttribute(products); // productList
		
		
		
		return "three";
	}
	

}
