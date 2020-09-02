package com.allstate.ceme.crm.controller;

import com.allstate.ceme.crm.model.CustomerInteraction;
import com.allstate.ceme.crm.service.CustomerInteractionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class CustomerInteractionController {
    private CustomerInteractionService customerInteractionService;

    public CustomerInteractionController(CustomerInteractionService customerInteractionService) {
        this.customerInteractionService = customerInteractionService;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/api/customers/{id}/interactions")
    public ResponseEntity<List<CustomerInteraction>> getAllCustomerInteractions(@PathVariable String id) {
        return ResponseEntity.ok(customerInteractionService.fetchAllInteractions(id));
    }

    @RequestMapping(method=RequestMethod.POST, value = "/api/customers/interactions")
    public void addNewCustomerInteraction(@RequestBody CustomerInteraction customerInteraction) {
        customerInteractionService.addNewCustomerInteraction(customerInteraction);
    }

    @RequestMapping(method=RequestMethod.PUT, value="/api/customers/interactions/{id}")
    public ResponseEntity<CustomerInteraction> updateCustomer(@RequestBody CustomerInteraction customerInteraction, @PathVariable("id") String id) {
        return ResponseEntity.ok(customerInteractionService.updateCustomerInteraction(id, customerInteraction));
    }

    @RequestMapping(method=RequestMethod.DELETE, value="/api/customers/interactions/{id}")
    public void deleteCustomer(@PathVariable("id") String id){
        customerInteractionService.deleteCustomerInteraction(id);
    }

}
