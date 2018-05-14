package com.dasetova.beitech_test.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="customer")
public class Customer implements Serializable{

	@Id
	@Column(name="customer_id")
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int id;
	
	@NotEmpty
    @Column(name="name", nullable=false)
	private String name;
	
	@NotEmpty
    @Column(name="email", nullable=false)
	private String email;
	
	@ManyToMany(cascade = {CascadeType.ALL})
	@JoinTable(
			name="customer_available_product", 
			joinColumns={@JoinColumn(name="customer_id")}, 
			inverseJoinColumns={@JoinColumn(name="product_id")}
	)
	private List<Product> availableProducts = new ArrayList<>();
	
	@OneToMany(mappedBy="customer")
    private List<Order> orders = new ArrayList<>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Product> getAvailableProducts() {
		return availableProducts;
	}

	public void setAvailableProducts(List<Product> availableProducts) {
		this.availableProducts = availableProducts;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
	
	public void addOrder(Order order) {
		this.orders.add(order);
		order.setCustomer(this);
	}
	
	public void removeOrder(Order order) {
		this.orders.remove(order);
		order.setCustomer(null);
	}
	
	
}
