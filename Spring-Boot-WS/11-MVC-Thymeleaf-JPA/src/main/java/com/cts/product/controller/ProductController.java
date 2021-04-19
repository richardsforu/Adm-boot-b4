package com.cts.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

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

	@RequestMapping("/saveProduct") // http://localhost:8080/saveproduct
	public String saveProduct(@ModelAttribute Product product) {
		System.out.println(">>>> saveProduct methd <<<<");

		prodDao.save(product);

		return "redirect:/listAllProducts";
	}

	@RequestMapping("/listAllProducts")
	public String listAllProducts(ModelMap mp) {

		mp.addAttribute("products", prodDao.findAll());

		return "products";
	}

	@RequestMapping("/loadSearchForm")
	public String loadSearchForm() {

		return "search-form";
	}

	@RequestMapping("/findProduct")
	public ModelAndView findProduct(@RequestParam("id") int id,@RequestParam("type")String type) {

		ModelAndView mav = new ModelAndView();
		String viewName = "";

		Product product = prodDao.findById(id).orElse(null);
		
		if (product != null) {
			
			if(type.equals("update")) {
			viewName = "update-form";
			mav.addObject("product", product);
			}else {
				prodDao.deleteById(id);
				viewName="redirect:/listAllProducts";
			}
		} else {
			viewName = "search-form";
			mav.addObject("msg","Product Id "+id+" Not found in database");
		}
		
		// set View Name.....
		mav.setViewName(viewName);

		return mav;
	}

}
