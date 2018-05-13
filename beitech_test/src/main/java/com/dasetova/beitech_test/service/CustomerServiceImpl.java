package com.dasetova.beitech_test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dasetova.beitech_test.model.Customer;
import com.dasetova.beitech_test.model.Order;
import com.dasetova.beitech_test.model.OrderDetail;
import com.dasetova.beitech_test.model.Product;
import com.dasetova.beitech_test.repositories.CustomerRepository;

@Service("customerService")
@Transactional
public class CustomerServiceImpl implements CustomerService{

	@Autowired
    private CustomerRepository customerRepository;
	
	@Override
	public Customer findByName(String name) {
		return customerRepository.findByName(name);
	}

	@Override
	public Customer findById(int id) {
		return customerRepository.findOne(id);
	}

	@Override
	public void updateCustomer(Customer customer) {
		customerRepository.save(customer);
	}

	@Override
	public boolean validateCustomerProducts(int id, Order order) {
		Customer customer = this.findById(id);
		for(OrderDetail orderDetail : order.getOrderDetails()) {
			Product product = orderDetail.getProduct();
			if (!customer.getAvailableProducts().contains(product)) {
				return false;
			}
		}
		return true;
	}
	
	
	
}
