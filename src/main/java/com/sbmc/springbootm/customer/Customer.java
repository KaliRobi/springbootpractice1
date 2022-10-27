package com.sbmc.springbootm.customer;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class Customer {
    private final Long id;
    @NotBlank
    private final String name;
    @NotBlank
    @JsonProperty(access=JsonProperty.Access.WRITE_ONLY)  // only write the password but not read (no get)
    private  final String password;


    @Email /// regex can be passed
    @NotBlank(message = "email must be not empty")
       private final String email;

    // some other anotation
    // @Max, @Min, @Digit, @List, @Decimal

    Customer(Long id, String name, String password, String email) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.email = email;
    }
    // these are returning the properties of the class
    @JsonProperty("customer_id")
    public Long getId() {
        return id;
    }
    @JsonIgnore
    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}