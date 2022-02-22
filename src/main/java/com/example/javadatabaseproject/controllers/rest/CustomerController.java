package com.example.javadatabaseproject.controllers.rest;

import com.example.javadatabaseproject.models.Customer;
import com.example.javadatabaseproject.access.layer.CustomerDao;
import com.example.javadatabaseproject.models.CustomerCountry;
import com.example.javadatabaseproject.models.CustomerGenre;
import com.example.javadatabaseproject.models.CustomerSpender;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.util.List;

@RestController
public class CustomerController   {

    private final CustomerDao customerDao;

    public CustomerController(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

   @RequestMapping(value = "/api/customers/search/id/{id}", method = RequestMethod.GET)
    public Customer getCustomerByPathId(@PathVariable String id){
        return customerDao.getCustomerById(id);
   }

   @RequestMapping(value = "/api/customers", method = RequestMethod.GET)
    public List<Customer> getCustomers(){
       return customerDao.getAllCustomers();
   }

    @RequestMapping(value ="/api/customers/subset/{limit}/{offset}", method = RequestMethod.GET)
    public List<Customer> getCustomerSubSet(@PathVariable String limit, @PathVariable String offset)  {
        return customerDao.getSubsetOfCustomers(limit, offset);
    }

    @RequestMapping(value = "/api/customers/search/name/{name}", method = RequestMethod.GET)
    public Customer getCustomerByPathName(Model model, @PathVariable String name){
        return customerDao.getCustomerByName(name);
    }

    @RequestMapping(value = "/api/insert/customers", method = RequestMethod.POST)
    public Customer insertCustomer(@RequestBody Customer customer){
        return customerDao.insertCustomer(customer);
    }

    @RequestMapping(value = "/api/update/customers", method = RequestMethod.POST)
    public Customer updateCustomer(@RequestBody Customer customer){
        return customerDao.updateCustomer(customer);
    }

    @RequestMapping(value = "/api/customers/groupByCountry", method = RequestMethod.GET)
    public List<CustomerCountry> getCustomerByCountry(){
        return customerDao.getCustomerByCountry();
    }

    @RequestMapping(value = "/api/customers/highestSpenders", method = RequestMethod.GET)
    public List<CustomerSpender>  getHighestSpender(){
        return customerDao.getHighestSpender();
    }

    @RequestMapping(value = "/api/customers/popular/genre/{id}", method = RequestMethod.GET)
    public List<CustomerGenre> getPopularGenre(@PathVariable int id){
        return customerDao.getPopularGenre(id);
    }

}
