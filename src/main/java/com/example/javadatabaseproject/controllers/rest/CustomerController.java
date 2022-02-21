package com.example.javadatabaseproject.controllers.rest;

import com.example.javadatabaseproject.models.Customer;
import com.example.javadatabaseproject.access.layer.CustomerDao;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class CustomerController   {

    private final CustomerDao customerDao;

    public CustomerController(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }


    @RequestMapping(value = "/api")
    public String home(Model model) {
        model.addAttribute("greeting", "Welcome");
        return "home";
    }

   @RequestMapping(value = "/api/customers/search/id/{id}", method = RequestMethod.GET)
    public String getCustomerByPathId(@PathVariable String id, Model model){
       model.addAttribute("customerById", customerDao.getCustomerById(id));
       return "CustomerById";

   }

   @RequestMapping(value = "/api/customers", method = RequestMethod.GET)
    public String getCustomers(Model model){
       model.addAttribute("customers", customerDao.getAllCustomers());
       return "CustomerMaxLimit";
   }


    @RequestMapping(value = "/api/customers/search/name/{name}", method = RequestMethod.GET)
    public String getCustomerByPathName(Model model, @PathVariable String name){
        model.addAttribute("customerByName", customerDao.getCustomerByName(name));
        return "CustomerByName";
    }

    @RequestMapping(value ="/api/customers/subset/{limit}/{offset}", method = RequestMethod.GET)
    public String getCustomerSubSet(Model model, @PathVariable String limit, @PathVariable String offset)  {
        model.addAttribute("customerSubset", customerDao.getSubsetOfCustomers(limit, offset));
        return "CustomerSubset";
    }
    @RequestMapping(value = "/api/insert/customers", method = RequestMethod.POST)
    public String insertCustomer(Model model,  @RequestBody Customer customer){
        model.addAttribute("customerBoolTrue", customerDao.insertCustomer(customer));
        return "CustomerInsert";
    }

    @RequestMapping(value = "/api/update/customers", method = RequestMethod.POST)
    public String updateCustomer(Model model,  @RequestBody Customer customer){
        model.addAttribute("customerByName", customerDao.updateCustomer(customer));
        return "customerByName";
    }
    @RequestMapping(value = "/api/customers/groupByCountry", method = RequestMethod.GET)
    public String getCustomerByCountry(Model model){
        model.addAttribute("customerByCountry", customerDao.getCustomerByCountry());
        return "CustomerCountry";
    }
    @RequestMapping(value = "/api/customers/highestSpenders", method = RequestMethod.GET)
    public String getHighestSpender(Model model){
        model.addAttribute("customerHighestSpender", customerDao.getHighestSpender());
        return "CustomerHighestSpender";
    }
    @RequestMapping(value = "/api/customers/popular/genre/{id}", method = RequestMethod.GET)
    public String getPopularGenre(Model model, @PathVariable int id){
        model.addAttribute("popularGenre", customerDao.getPopularGenre(id));
        return "CustomerPopularGenre";
    }

}
