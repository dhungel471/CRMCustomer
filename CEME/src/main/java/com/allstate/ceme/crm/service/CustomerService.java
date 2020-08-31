package com.allstate.ceme.crm.service;

import java.util.Collection;
import java.util.Optional;

import com.allstate.ceme.crm.data.CustomerRepository;
import com.allstate.ceme.crm.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository custRepo;

    //Get List of Customer
    public Collection<Customer> getAllCustomer() {
        return custRepo.findAll();
    }

    //Get a list of customer by ID
    public Optional<Customer> getCustomerWithID(String id){
        return custRepo.findById(id);
    }

    //Add new Customer
    public void addNewCustomer(Customer custInfo){
        custRepo.insert(custInfo);
    }

    //Update Customer
    public Customer updateCustomer(String id, Customer custInfo){
        return custRepo.save(custInfo);
    }

    //Delete Customer
    public void deleteCustomer(String id){
        custRepo.deleteById(id);
    }
}

