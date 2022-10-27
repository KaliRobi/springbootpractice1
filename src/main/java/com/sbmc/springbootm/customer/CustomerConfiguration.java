package com.sbmc.springbootm.customer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomerConfiguration {

    @Value("${app.useFakeCustomerRepo:true}")
    private Boolean useFakeCustomerRepo;

    @Bean   // this starts when the application starts so when it starts it is executed
    CommandLineRunner commandLineRunner(){
        return args -> {
            System.out.println("command line runner runs");

        };
    }

    @Bean
    CustomerRepo customerRepo(){
        System.out.println("useFakeCustomerRepo = " + useFakeCustomerRepo);
        return useFakeCustomerRepo ? new CustomerFakeRepo() : new CustomerRepository();
    }

}
