package com.dasetova.beitech_test.repositories;

import com.dasetova.beitech_test.model.Customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

	Customer findByName(String name);
}
