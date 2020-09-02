package com.allstate.ceme.crm.controller;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class CustomerControllerSmokeTest {

    @Autowired
    private CustomerController customerController;

    @Test
    public void smokeTest() throws Exception {
        assertThat(customerController).isNotNull();
    }
}