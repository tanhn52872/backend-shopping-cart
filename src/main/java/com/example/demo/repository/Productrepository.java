package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Product;

@Repository
public interface Productrepository extends JpaRepository<Product, Integer> {
//	@Query(value="select * from Product", nativeQuery = true)
	List<Product> findAll();
	@Query(value ="select * from Product p where p.ID = '001'", nativeQuery = true)
	Product findProductById(@Param("id") Integer id);
}
