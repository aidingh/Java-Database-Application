package com.example.javadatabaseproject.controllers.rest;

import com.example.javadatabaseproject.models.Customer;
import com.example.javadatabaseproject.repositories.CustomerRepository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.ArrayList;

@RestController
public class CustomerController {

    CustomerRepository customerRepo = new CustomerRepository();

   @GetMapping("/api/")
    public String index(){
       String message = "TEST 1 2 3, this is the root brotha!";
       return message;
   }

   @GetMapping("/api/customers")
    public ArrayList<Customer> getCustomer() throws SQLException {
       customerRepo.establishConnection();
       return customerRepo.getAllCustomers();
   }

   @RequestMapping(value = "/api/customer/add", method = RequestMethod.POST)
    public boolean addNewCustomer(@RequestBody Customer customer) throws  SQLException{
       customerRepo.establishConnection();
       return customerRepo.addNewCustomer(customer);
   }


}
