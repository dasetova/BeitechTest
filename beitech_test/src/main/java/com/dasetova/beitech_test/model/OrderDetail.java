package com.dasetova.beitech_test.model;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name="order_detail")
public class OrderDetail implements Serializable{

	@Id
	@Column(name="order_detail_id")
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int id;
	
	@Column(name="quantity", nullable=false)
	private int quantity;
	
	@Column(name="price", nullable=false)
	private int price;
	
	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
	@PrimaryKeyJoinColumn
    private Product product;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
}
