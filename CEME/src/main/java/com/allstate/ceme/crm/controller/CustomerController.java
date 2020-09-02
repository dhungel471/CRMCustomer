package com.allstate.ceme.crm.controller;

import java.util.Collection;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.allstate.ceme.crm.model.Customer;
import com.allstate.ceme.crm.service.CustomerService;

@RestController
@CrossOrigin
@RequestMapping("/api/customers")
public class CustomerController {
    private CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public Collection<Customer> getAllCustomer() {
        return customerService.getAllCustomer();
    }

    @RequestMapping(method = RequestMethod.GET, value="/{id}")
    public Optional<Customer> getCustomerWithID(@PathVariable("id") String id) {
        return customerService.getCustomerWithID(id);
    }

  @RequestMapping(method=RequestMethod.POST)
  public void addNewCustomer(@RequestBody Customer custInfo) {
      customerService.addNewCustomer(custInfo);
  }

  @RequestMapping(method=RequestMethod.PUT, value="/{id}")
  public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer, @PathVariable("id") String id) {
    return ResponseEntity.ok(customerService.updateCustomer(id, customer));
  }
  @CrossOrigin
  @RequestMapping(method=RequestMethod.DELETE, value="/{id}")
  public void deleteCustomer(@PathVariable("id") String id){
      customerService.deleteCustomer(id);
  }
}
