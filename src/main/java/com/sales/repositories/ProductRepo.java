package com.sales.repositories;

import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

import com.sales.models.Product;

// Repository class for product
@Repository
public interface ProductRepo extends CrudRepository <Product, Long> {

}
