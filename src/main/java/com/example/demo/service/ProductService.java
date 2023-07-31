package com.example.demo.service;

import com.example.demo.entity.Product;
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

    public void createProduct(Product product, Category category) {
        Product newProduct = new Product();
        newProduct.setDescription(product.getDescription());
        newProduct.setImageURL(product.getImageURL());
        newProduct.setName(product.getName());
        newProduct.setCategory(category);
        newProduct.setPrice(product.getPrice());
        productDAO.save(newProduct);
    }

    public void updateProduct(Product product, Integer productId) throws Exception {
        if(productDAO.findProductById(productId)!=null) {
            Product newpProduct = productDAO.findProductById(productId);
            newpProduct.setDescription(product.getDescription());
            newpProduct.setImageURL(product.getImageURL());
            newpProduct.setPrice(product.getPrice());
            productDAO.save(newpProduct);
        }
        else{
            throw new Exception("product not present");
        }
    }

    public void deleteAllProduct(){
        productDAO.deleteAll();
    }

}