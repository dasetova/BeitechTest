package com.dasetova.beitech_test.service;

import com.dasetova.beitech_test.model.Customer;
import com.dasetova.beitech_test.model.Order;

public interface CustomerService {

	Customer findByName(String name);
	Customer findById(int id);
	void updateCustomer(Customer customer);
	boolean validateCustomerProducts(int id, Order order);
}
