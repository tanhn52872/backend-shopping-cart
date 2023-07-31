package com.example.demo.entity;

import com.example.demo.entity.Product;
import com.example.demo.entity.Category;
import com.fasterxml.jackson.annotation.JsonIgnore;


import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "products")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	private  String name;
	private  String imageURL;
	private  double price;
	private  String description;




	@ManyToOne
	@JsonIgnore
	//@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "category_id")
	Category category;


//	@OneToMany(fetch = FetchType.LAZY, mappedBy = "product")
//	private List<WishList> wishListList;
//	@JsonIgnore
//	@OneToMany(fetch = FetchType.LAZY, mappedBy = "product")
//	private List<Cart> carts;

	public Product(Product productDto, Category category) {
		this.name = productDto.getName();
		this.imageURL = productDto.getImageURL();
		this.description = productDto.getDescription();
		this.price = productDto.getPrice();
		this.category = category;
	}

	public Product(String name, String imageURL, double price, String description, Category category) {
		super();
		this.name = name;
		this.imageURL = imageURL;
		this.price = price;
		this.description = description;
		this.category = category;
	}

	public Product() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImageURL() {
		return imageURL;
	}

	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

//	public Integer getCategoryId() {
//		return categoryId;
//	}
//
//	public void setCategoryId(Integer categoryId) {
//		this.categoryId = categoryId;
//	}

	@Override
	public String toString() {
		return "Product{" +
				"id=" + id +
				", name='" + name + '\'' +
				", imageURL='" + imageURL + '\'' +
				", price=" + price +
				", description='" + description + '\'' +
				'}';
	}
}