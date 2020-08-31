package com.allstate.ceme.crm.controller;

import com.allstate.ceme.crm.model.CustomerInteraction;
import com.allstate.ceme.crm.service.CustomerInteractionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class CustomerInteractionController {
    @Autowired
    private CustomerInteractionService customerInteractionService;
    
    @RequestMapping(method = RequestMethod.GET, value = "/api/customers/{id}/interactions")
    public ResponseEntity<List<CustomerInteraction>> getAllCustomerInteractions(@PathVariable String id) {
        return ResponseEntity.ok(customerInteractionService.fetchAllInteractions(id));
    }

    @RequestMapping(method=RequestMethod.POST, value = "/api/customers/interactions")
    public void addNewCustomerInteraction(@RequestBody CustomerInteraction customerInteraction) {
        customerInteractionService.addNewCustomerInteraction(customerInteraction);
    }

}
