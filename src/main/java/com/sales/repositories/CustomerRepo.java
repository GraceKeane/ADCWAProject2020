package com.sales.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sales.models.Customer;

//Repository class for customer
@Repository
public interface CustomerRepo extends CrudRepository <Customer, Long> {

}
