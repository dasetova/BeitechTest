package com.dasetova.beitech_test.service;

import com.dasetova.beitech_test.model.Order;
import com.dasetova.beitech_test.model.OrderDetail;

public interface OrderDetailService {

	void saveOrderDetail(OrderDetail orderDetail);
	
	void saveOrderOrderDetails(Order order);
}
