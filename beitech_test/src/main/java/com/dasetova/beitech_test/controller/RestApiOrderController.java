package com.dasetova.beitech_test.controller;

import java.time.LocalDate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.dasetova.beitech_test.model.Order;
import com.dasetova.beitech_test.service.OrderService;
import com.dasetova.beitech_test.util.CustomErrorType;

@RestController
@RequestMapping("/api/order")
public class RestApiOrderController {

    public static final Logger logger = LoggerFactory.getLogger(RestApiOrderController.class);
    
    @Autowired
    OrderService orderService;
    
    @RequestMapping(value = "/create/", method = RequestMethod.POST)
    public ResponseEntity<?> createOrder(@RequestBody Order order, UriComponentsBuilder ucBuilder) {
    	logger.info("Creating new order: {}", order);
    	try {
    		orderService.addOrder(order);
    	}catch(Exception e) {
    		logger.error("Unable to order");
            return new ResponseEntity(new CustomErrorType("Unable to create Order "),HttpStatus.CONFLICT);
    	}
    	HttpHeaders headers = new HttpHeaders();
    	headers.setLocation(ucBuilder.path("/api/order/{id}").buildAndExpand(order.getId()).toUri());
    	return new ResponseEntity(headers, HttpStatus.CREATED);
    }
}
