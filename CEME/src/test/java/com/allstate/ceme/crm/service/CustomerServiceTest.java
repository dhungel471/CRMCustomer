package com.allstate.ceme.crm.service;

import com.allstate.ceme.crm.data.CustomerRepository;
import com.allstate.ceme.crm.model.Customer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;

@SpringBootTest
public class CustomerServiceTest {

    @MockBean
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerService customerService;

    private final Customer rihanna = new Customer("123", "Rihanna", "Fenty", "111-222-3333", "123 Hollywood Blvd");
    private final Customer britney = new Customer("456", "Britney", "Spears", "222-222-3333", "456 Hollywood Blvd");
    private List<Customer> customerList = Arrays.asList(rihanna, britney);
    private Collection<Customer> customerCollection = customerList;

    @Test
    void getAllCustomer() {
        doReturn(customerList).when(customerRepository).findByOrderByLastNameAsc();

        Collection<Customer> receivedCustomers = customerService.getAllCustomer();
        assertEquals(receivedCustomers.size(), 2);

        assertTrue(receivedCustomers.containsAll(Arrays.asList(rihanna, britney)));
    }
}