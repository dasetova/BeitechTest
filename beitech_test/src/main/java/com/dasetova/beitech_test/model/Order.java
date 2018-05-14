package com.dasetova.beitech_test.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import org.hibernate.validator.constraints.NotEmpty;
import org.omg.CORBA.ServerRequest;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name="order_resume")
public class Order implements Serializable{

	@Id
	@Column(name="order_id")
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int id;
	
	@NotEmpty
    @Column(name="delivery_address", nullable=true)
	private String deliveryAddress;
	
	@Column(name="creation_date", nullable=false)
	private LocalDate creationDate;
	
	@OneToMany(mappedBy="order_resume")
    private List<OrderDetail> orderDetails = new ArrayList<>();
	
	@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property="id", scope=ServerRequest.class)
	@ManyToOne
    @JoinColumn(name="customer_id", nullable=false)
    private Customer customer;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDeliveryAddress() {
		return deliveryAddress;
	}

	public void setDeliveryAddress(String deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}

	public LocalDate getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(LocalDate creationDate) {
		this.creationDate = creationDate;
	}

	public List<OrderDetail> getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(List<OrderDetail> orderDetails) {
		this.orderDetails = orderDetails;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	
	
}
