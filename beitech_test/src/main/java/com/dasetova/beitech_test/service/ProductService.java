package com.dasetova.beitech_test.service;

import java.util.List;

import com.dasetova.beitech_test.model.Product;

public interface ProductService {

	List<Product> customerAvailableProducts(int customer_id);
}
