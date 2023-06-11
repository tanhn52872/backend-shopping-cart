package com.example.demo.service;

import com.example.demo.dto.product.ProductDto;
import com.example.demo.entity.Category;
import com.example.demo.entity.Product;

import com.example.demo.repository.Productrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    Productrepository productDAO;

    public List<Product> findAllProduct() {
        List<Product> listProduct = new ArrayList<>();
        listProduct = this.productDAO.findAll();
        return listProduct;
    }

    public Product findProductById(Integer id) {
        Product product = new Product();
        product = this.productDAO.findProductById(id);
        return product;
    }

    public void createProduct(ProductDto productDto, Category category) {
        Product product = new Product();
        product.setDescription(productDto.getDescription());
        product.setImageURL(productDto.getImageURL());
        product.setName(productDto.getName());
        product.setCategory(category);
        product.setPrice(productDto.getPrice());
        productDAO.save(product);
    }

    public void updateProduct(ProductDto productDto, Integer productId) throws Exception {
        if(productDAO.findProductById(productId)!=null) {
            Product newpProduct = productDAO.findProductById(productId);
            newpProduct.setDescription(productDto.getDescription());
            newpProduct.setImageURL(productDto.getImageURL());
            newpProduct.setPrice(productDto.getPrice());
            productDAO.save(newpProduct);
        }
        else{
            throw new Exception("product not present");
        }
    }
}