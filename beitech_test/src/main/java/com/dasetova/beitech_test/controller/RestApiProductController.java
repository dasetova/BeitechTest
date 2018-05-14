package com.dasetova.beitech_test.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dasetova.beitech_test.model.Product;
import com.dasetova.beitech_test.service.ProductService;
import com.dasetova.beitech_test.util.CustomErrorType;

@RestController
@RequestMapping("/api/product")
public class RestApiProductController {

public static final Logger logger = LoggerFactory.getLogger(RestApiOrderController.class);
    
    @Autowired
    ProductService productService;
    
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ResponseEntity<List<Product>> listCustomerAvailableProducts(@RequestParam("customer_id") Integer customer_id) {
    	logger.info("Retrieving products");
    	List<Product> products;
    	try {
    		products = productService.customerAvailableProducts(customer_id);
    	}catch(Exception e) {
    		logger.error("Unable to retrieve products");
            return new ResponseEntity(new CustomErrorType("Unable to retrieve products"),HttpStatus.CONFLICT);
    	}
    	return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
    }
}
