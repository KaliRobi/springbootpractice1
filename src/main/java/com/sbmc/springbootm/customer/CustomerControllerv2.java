package com.sbmc.springbootm.customer;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;

@RequestMapping(path= "api/v2/customers/")
@RestController
public class CustomerControllerv2 {

    private final CustomerService customerService;

    @Autowired
    public CustomerControllerv2(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    List<Customer> getCustomers() {
        return customerService.getCustomer();
    }

    @GetMapping(path = "{customerID}")
    Customer getCustomer(@PathVariable("customerID") Long id) {
        return customerService.getCustomer().stream().filter(customer -> customer.getId().equals(id)).findAny().orElseThrow(
                () -> new IllegalStateException("customer not found")
        );

    }

    @PostMapping  // creating post api, the @Requestbody points to the json payload of the received json file
    void createNewCustomer(@RequestBody @Valid Customer customer){
        System.out.println("POST REQUEST..");
        System.out.println(customer);
    }

    @PutMapping  // creating post api, the @Requestbody points to the json payload of the received json file
    void updateNewCustomer(@RequestBody Customer customer){
        System.out.println("Update REQUEST..");
        System.out.println(customer);
    }

    @DeleteMapping(path = "{customerID}") // this is where the receiving data is specified
    void deleteCustomer(@PathVariable("customerID") Long id){  // here the path variable and the type needs to match to the one what we expect from the client
        System.out.println("DELETE REQUEST.." + id);

    }

}