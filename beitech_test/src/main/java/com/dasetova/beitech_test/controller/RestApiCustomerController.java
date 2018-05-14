package com.dasetova.beitech_test.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dasetova.beitech_test.model.Customer;
import com.dasetova.beitech_test.service.CustomerService;
import com.dasetova.beitech_test.util.CustomErrorType;

@RestController
@RequestMapping("/api/customer")
public class RestApiCustomerController {

	public static final Logger logger = LoggerFactory.getLogger(RestApiOrderController.class);
    
    @Autowired
    CustomerService customerService;
    
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ResponseEntity<List<Customer>> listAllCustomers() {
    	logger.info("Retrieving products");
    	List<Customer> customers;
    	try {
    		customers = customerService.getAllCustomers();
    	}catch(Exception e) {
    		logger.error("Unable to retrieve customers");
            return new ResponseEntity(new CustomErrorType("Unable to retrieve customers"),HttpStatus.CONFLICT);
    	}
    	return new ResponseEntity<List<Customer>>(customers, HttpStatus.OK);
    }
}
