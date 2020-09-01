package com.allstate.ceme.crm.service;

import com.allstate.ceme.crm.data.CustomerInteractionRepository;
import com.allstate.ceme.crm.model.CustomerInteraction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerInteractionService {
    @Autowired
    private CustomerInteractionRepository customerInteractionRepository;

    public CustomerInteractionService(CustomerInteractionRepository customerInteractionRepository) {
        this.customerInteractionRepository = customerInteractionRepository;
    }

    public List<CustomerInteraction> fetchAllInteractions(String customerId){
        return customerInteractionRepository.findByCustomerIdOrderByCreatedDate(customerId);
    }

    public void addNewCustomerInteraction(CustomerInteraction customerInteraction) {
        customerInteractionRepository.save(customerInteraction);
    }

    public CustomerInteraction updateCustomerInteraction(String id, CustomerInteraction customerInteraction) {
        return customerInteractionRepository.save(customerInteraction);
    }

    public void deleteCustomerInteraction(String id) {
        customerInteractionRepository.deleteById(id);
    }
}
