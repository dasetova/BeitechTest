package com.dasetova.beitech_test.service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dasetova.beitech_test.model.*;
import com.dasetova.beitech_test.repositories.OrderRepository;

@Service("orderService")
@Transactional
public class OrderServiceImpl implements OrderService{

	@Autowired
    private CustomerService customerService;
	
	@Autowired
    private OrderDetailService orderDetailService;
	
	@Autowired
    private OrderRepository orderRepository;
	
	public void addOrder(Order order) {
		Customer customer = customerService.findById(order.getCustomer().getId());
		customer.addOrder(order);
		if (customerService.validateCustomerProducts(order.getCustomer().getId(), order)
				&& this.validateOrder(order)) {
			this.saveOrder(order);
			orderDetailService.saveOrderOrderDetails(order);
		}
	}
	
	@Override
	public List<Order> ordersByCustomerAndDates(int customer_id, LocalDate lowerDate, LocalDate upperDate) {
		Customer customer = customerService.findById(customer_id);
		List<Order> ordersFiltered = customer.getOrders().stream()
				.filter((order) -> order.getCreationDate().isAfter(lowerDate) && order.getCreationDate().isBefore(upperDate) )
				.collect(Collectors.toList());
		return ordersFiltered;
	}

	@Override
	public void saveOrder(Order order) {
		orderRepository.save(order);
	}

	@Override
	public boolean validateOrder(Order order) {
		int sum = 0;
		for(OrderDetail o: order.getOrderDetails()) {
			sum+=o.getQuantity();
		}
		return (sum<=5);
	}
	
	
}