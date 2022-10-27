package com.sbmc.springbootm.customer;

import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository(value = "fake")
public class CustomerFakeRepo implements CustomerRepo {
    @Override
    public List<Customer> getCustomers() {
        return Arrays.asList(
                new Customer(3L, "James Bond", "123password", "email@gmail.com"),
                new Customer(2L, "Jamila Ahmed", "password123", "email@gmail.com")
        );
    }
}
