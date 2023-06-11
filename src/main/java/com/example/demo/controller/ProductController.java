package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.demo.common.ApiResponse;
import com.example.demo.dto.product.ProductDto;
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
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public List<Product> getAllProducts(){
		List<Product> products = new ArrayList<>();
		System.out.println(this.productService.findAllProduct());
		return this.productService.findAllProduct();
	}
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public ResponseEntity<ApiResponse> createProduct(@RequestBody ProductDto productDTO){
		Optional<Category> optionalCategory = categoryrepository.findById(productDTO.getCategoryId());
		if(optionalCategory.isPresent()){
			return new ResponseEntity<ApiResponse>(new ApiResponse(false,"category is not exists"),HttpStatus.BAD_REQUEST);
		}
		productService.createProduct(productDTO,optionalCategory.get());
		return new ResponseEntity<ApiResponse>(new ApiResponse(true,"product has been added"), HttpStatus.CREATED);
	}
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public ResponseEntity<ApiResponse> editProduct(@PathVariable ("productId") Integer productId, @RequestBody ProductDto productDto) throws Exception {
		productService.updateProduct(productDto,productId);
		return new ResponseEntity<ApiResponse>(new ApiResponse(true,"product has been added"), HttpStatus.CREATED);
	}
}
