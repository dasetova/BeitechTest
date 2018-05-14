package com.dasetova.beitech_test.service;

import java.time.LocalDate;
import java.util.List;

import com.dasetova.beitech_test.model.Order;

public interface OrderService {

	void addOrder(Order order);
	
	List<Order> ordersByCustomerAndDates (int customer_id, LocalDate lowerDate, LocalDate upperDate);
	
	void saveOrder(Order order);
}
