package com.example.javadatabaseproject.controllers.rest;

import com.example.javadatabaseproject.models.Customer;
import com.example.javadatabaseproject.repositories.CustomerRepository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.ArrayList;

@RestController
public class CustomerController {

    CustomerRepository customerRepo = new CustomerRepository();

    /*@RequestMapping(value = "/api/")
    public String home(Model model){
        model.addAttribute("greeting", "Welcome buskin");
        return "home";
    }*/

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


}
