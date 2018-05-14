package com.dasetova.beitech_test.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dasetova.beitech_test.model.Customer;
import com.dasetova.beitech_test.model.Product;

@Service("productService")
@Transactional
public class ProductServiceImpl implements ProductService{

	@Autowired
	CustomerService customerService;
	
	
	@Override
	public List<Product> customerAvailableProducts(int customer_id) {
		// TODO Auto-generated method stub
		Customer customer = customerService.findById(customer_id);
		return customer.getAvailableProducts();
	}

}
