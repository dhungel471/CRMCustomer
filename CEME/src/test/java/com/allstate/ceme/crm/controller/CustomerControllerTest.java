package com.allstate.ceme.crm.controller;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.allstate.ceme.crm.model.Customer;
import com.allstate.ceme.crm.service.CustomerService;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@WebMvcTest(CustomerController.class)
public class CustomerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CustomerService customerService;

    private final Customer rihanna = new Customer("123", "Rihanna", "Fenty", "111-222-3333", "123 Hollywood Blvd");
    private final Customer britney = new Customer("123", "Britney", "Spears", "222-222-3333", "456 Hollywood Blvd");
    private List<Customer> customerList = Arrays.asList(rihanna, britney);
    private Collection<Customer> customerCollection = customerList;


    @Test
    public void getShouldReturnJson() throws Exception {
        when(customerService.getAllCustomer()).thenReturn(customerCollection);

        this.mockMvc.perform(get("/api/customers"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    public void getShouldReturnCustomers() throws Exception {
        String expectedResult = "[{\"id\":\"123\",\"firstName\":\"Rihanna\",\"lastName\":\"Fenty\",\"phoneNumber\":\"111-222-3333\",\"address\":\"123 Hollywood Blvd\"},{\"id\":\"123\",\"firstName\":\"Britney\",\"lastName\":\"Spears\",\"phoneNumber\":\"222-222-3333\",\"address\":\"456 Hollywood Blvd\"}]";
        when(customerService.getAllCustomer()).thenReturn(customerCollection);

        this.mockMvc.perform(get("/api/customers"))
                .andExpect(status().isOk())
                .andExpect(content().json(expectedResult));
    }
}