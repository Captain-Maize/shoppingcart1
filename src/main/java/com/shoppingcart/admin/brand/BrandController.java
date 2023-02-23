package com.shoppingcart.admin.brand;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.shoppingcart.admin.category.CategoryService;
import com.shoppingcart.admin.entity.Brand;
import com.shoppingcart.admin.entity.Category;

@Controller
public class BrandController {
	@Autowired
	private BrandService brandService;
	
	@Autowired
	private CategoryService categoryService;

	@GetMapping("/brands")
	public String listAll(Model model) {
		List<Brand> listBrandsToView = brandService.listAll();
		model.addAttribute("listBrands", listBrandsToView);
		
		return "brands/brands";
	}
	
	@GetMapping("/brands/new")
	public String showBrandInputForm(Model model) {
		Brand brand = new Brand();
		List<Category> listCategories = categoryService.listCategoriesUsedInForm();
		
		model.addAttribute("brand", brand);//keyvalue 'brand' in html
		model.addAttribute("listCategories", listCategories);
		model.addAttribute("pageTitle", "Create New Brand");
		return "brands/brands_form";
	}

}
