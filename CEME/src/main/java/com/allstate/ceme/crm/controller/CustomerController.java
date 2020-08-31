package com.allstate.ceme.crm.controller;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    private CustomerService cemeCustomerService;
    
    @RequestMapping(method = RequestMethod.GET)
    public Collection<Customer> getAllCustomer() {
        return cemeCustomerService.getAllCustomer();
    }

    @RequestMapping(method = RequestMethod.GET, value="/{id}")
    public Optional<Customer> getCustomerWithID(@PathVariable("id") String id) {
        return cemeCustomerService.getCustomerWithID(id);
    }

  @RequestMapping(method=RequestMethod.POST)
  public void addNewCustomer(@RequestBody Customer custInfo) {
    cemeCustomerService.addNewCustomer(custInfo);
  }

  @RequestMapping(method=RequestMethod.PUT, value="/{id}")
  public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer, @PathVariable("id") String id) {
    return ResponseEntity.ok(cemeCustomerService.updateCustomer(id, customer));
  }
  @CrossOrigin
  @RequestMapping(method=RequestMethod.DELETE, value="/{id}")
  public void deleteCustomer(@PathVariable("id") String id){
    cemeCustomerService.deleteCustomer(id);
  }
}
