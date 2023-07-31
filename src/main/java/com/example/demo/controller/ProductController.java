package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.demo.common.ApiResponse;
import com.example.demo.entity.Product;
import com.example.demo.entity.Category;
import com.example.demo.repository.Categoryrepository;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.entity.Product;

@RestController
@RequestMapping("/product")

public class ProductController {
	@Autowired
	Categoryrepository categoryrepository;
	@Autowired
	ProductService productService;
	@RequestMapping(value="/listProduct",method=RequestMethod.GET)
	public List<Product> getAllProducts(){
		List<Product> products = new ArrayList<>();
		System.out.println(this.productService.findAllProduct());
		return this.productService.findAllProduct();
	}
	@RequestMapping(value="/addProduct",method=RequestMethod.POST)
	public ResponseEntity<ApiResponse> createProduct(@RequestBody Product product){
		Optional<Category> optionalCategory = categoryrepository.findById(product.getCategory().getId());
		if(!optionalCategory.isPresent()){
			return new ResponseEntity<ApiResponse>(new ApiResponse(false,"category is not exists"),HttpStatus.BAD_REQUEST);
		}
		productService.createProduct(product,optionalCategory.get());
		return new ResponseEntity<ApiResponse>(new ApiResponse(true,"product has been added"), HttpStatus.CREATED);
	}
	@PostMapping(value="/updateProduct/{productId}")
	public ResponseEntity<ApiResponse> editProduct(@PathVariable ("productId") Integer productId, @RequestBody Product product) throws Exception {
		productService.updateProduct(product,productId);
		return new ResponseEntity<ApiResponse>(new ApiResponse(true,"product has been added"), HttpStatus.CREATED);
	}
	@DeleteMapping("/deleteAllProducts/")
	public void deleteAllProducts(){
		productService.deleteAllProduct();
		System.out.println("All products have been deleted");
	}
}
