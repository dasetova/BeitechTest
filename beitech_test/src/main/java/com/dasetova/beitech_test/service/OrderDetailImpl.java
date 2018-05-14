package com.dasetova.beitech_test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dasetova.beitech_test.model.Order;
import com.dasetova.beitech_test.model.OrderDetail;
import com.dasetova.beitech_test.repositories.OrderDetailRepository;

@Service("orderDetailService")
@Transactional
public class OrderDetailImpl implements OrderDetailService{

	@Autowired
	private OrderDetailRepository orderDetailRepository;
	
	@Override
	public void saveOrderDetail(OrderDetail orderDetail) {
		orderDetailRepository.save(orderDetail);
	}

	@Override
	public void saveOrderOrderDetails(Order order) {
		for(OrderDetail orderDetail : order.getOrderDetails()) {
			orderDetail.setOrder_resume(order);
			this.saveOrderDetail(orderDetail);
		}
	}

}
