package com.dasetova.beitech_test.model;

import java.io.Serializable;

import javax.persistence.*;

import org.omg.CORBA.ServerRequest;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

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
	
	@ManyToOne
    @JoinColumn(name="product_id", nullable=false)
    private Product product;
	
	@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property="id", scope=ServerRequest.class)
	@ManyToOne
    @JoinColumn(name="order_id", nullable=false)
	private Order order_resume;

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

	public Order getOrder_resume() {
		return order_resume;
	}

	public void setOrder_resume(Order order_resume) {
		this.order_resume = order_resume;
	}
	
	
	
}
