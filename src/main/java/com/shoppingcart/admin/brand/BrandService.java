package com.shoppingcart.admin.brand;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shoppingcart.admin.category.CategoryNotFoundException;
import com.shoppingcart.admin.entity.Brand;

@Service
@Transactional
public class BrandService {

	@Autowired
	private BrandRepository repo;

	public Brand save(Brand brand) {
		return repo.save(brand);
	}

	public void deleteBrand(Integer id) throws BrandNotFoundException {
		Long countById = repo.countById(id);
		if (countById == null || countById == 0) {
			throw new BrandNotFoundException("Could not find any brands with id = " + id);
		}
		repo.deleteById(id);
	}

	public List<Brand> listAll() {
		return (List<Brand>) repo.findAll();
	}

//	public List<Brand> listBrandsUsedInForm() {
//		List<Brand> brandsUsedInForm = new ArrayList<>();
//
//	}

}
