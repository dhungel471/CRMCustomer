package com.allstate.ceme.crm.data;

import com.allstate.ceme.crm.model.CustomerInteraction;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CustomerInteractionRepository extends MongoRepository<CustomerInteraction, String> {
    List<CustomerInteraction> findByCustomerIdOrderByCreatedDate(String customerId);
}