package com.example.demo;

import com.example.demo.entity.Product;


import com.example.demo.service.ProductService;
import org.junit.Assert;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;


public class AngularShoppingCartApplicationTests {
	ProductService productService = new ProductService();

	//Test
	public void testDAO() {
		List<Product> actual = productService.findAllProduct();
		Assert.assertFalse( actual.isEmpty());
	}
}
