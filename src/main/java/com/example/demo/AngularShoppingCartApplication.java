package com.example.demo;

import com.example.demo.entity.Product;
import com.example.demo.service.ProductService;
import org.springframework.context.ApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.util.List;


@SpringBootApplication()
public class AngularShoppingCartApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(AngularShoppingCartApplication.class, args);

	}
}
