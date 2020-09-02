package com.allstate.ceme.crm.service;

import java.util.Collection;
import java.util.Optional;

import com.allstate.ceme.crm.data.CustomerRepository;
import com.allstate.ceme.crm.model.Customer;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    private CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    //Get List of Customer
    public Collection<Customer> getAllCustomer() {
        return customerRepository.findByOrderByLastNameAsc();
    }

    //Get a list of customer by ID
    public Optional<Customer> getCustomerWithID(String id){
        return customerRepository.findById(id);
    }

    //Add new Customer
    public void addNewCustomer(Customer custInfo){
        customerRepository.insert(custInfo);
    }

    //Update Customer
    public Customer updateCustomer(String id, Customer custInfo){
        return customerRepository.save(custInfo);
    }

    //Delete Customer
    public void deleteCustomer(String id){
        customerRepository.deleteById(id);
    }
}

