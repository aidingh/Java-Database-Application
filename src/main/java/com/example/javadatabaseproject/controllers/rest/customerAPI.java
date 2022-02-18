package com.example.javadatabaseproject.controllers.rest;

import com.example.javadatabaseproject.models.Customer;
import com.example.javadatabaseproject.repositories.CustomerRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class customerAPI {

    CustomerRepository customerRepo = new CustomerRepository();

   @GetMapping("/api/")
    public String index(){
       String message = "TEST 1 2 3, this is the root brotha!";
       return message;
   }

   @GetMapping("/api/customers")
    public ArrayList<Customer> getCustomer(){
       return customerRepo.getAllCustomer();
   }

}
