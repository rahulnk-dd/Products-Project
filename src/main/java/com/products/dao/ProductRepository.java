package com.products.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.products.entity.ProductEntity;

public interface ProductRepository extends JpaRepository<ProductEntity, Integer> {

}
