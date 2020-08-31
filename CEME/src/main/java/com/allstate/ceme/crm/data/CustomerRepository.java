package com.allstate.ceme.crm.data;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.allstate.ceme.crm.model.Customer;

public interface CustomerRepository extends MongoRepository<Customer, String> {
    public List<Customer> findByLastName(String lastName);
}