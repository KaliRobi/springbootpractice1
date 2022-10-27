package com.sbmc.springbootm.customer;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLOutput;
import java.util.List;

@RequestMapping(path= "api/v1/customer/")
@RestController
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping(value = "all")
    List<Customer> getCustomer() {
        return customerService.getCustomer();
    }

    @PostMapping  // creating post api, the @Requestbody points to the json payload of the received json file
    void createNewCustomer(@RequestBody Customer customer){
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