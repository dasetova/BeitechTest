package com.dasetova.beitech_test.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dasetova.beitech_test.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

}
