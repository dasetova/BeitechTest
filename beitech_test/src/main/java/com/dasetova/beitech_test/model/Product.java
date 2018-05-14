package com.dasetova.beitech_test.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="product")
public class Product implements Serializable{

	@Id
	@Column(name="product_id")
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int id;
	
	@NotEmpty
    @Column(name="name", nullable=false)
	private String name;
	
	@Column(name="price", nullable=false)
	private int price;
	
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

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public boolean equals(Object other){
	    if (other == null) return false;
	    if (other == this) return true;
	    if (!(other instanceof Product))return false;
	    Product otherMyClass = (Product)other;
	    return (otherMyClass.getId() == this.getId());
	}
		
}
