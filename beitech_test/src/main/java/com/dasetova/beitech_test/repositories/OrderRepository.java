package com.dasetova.beitech_test.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dasetova.beitech_test.model.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

}
