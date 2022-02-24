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

/**
 * @author Aidin Ghassemloi och Richard Cruz.
 * RestController returns query request made by the client in a JSON-format.
 */

@RestController
public class CustomerController   {

    private final CustomerDao customerDao;

    public CustomerController(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    /**
     * Endpoint will return a customer searched by id.
     * But if there is a search and the track is found, then it will be displayed for the client.
     *
     * @param id is a PathVariable defined by the client
     * @return Customer object is returned with user information in a JSON-format.
     */
   @RequestMapping(value = "/api/customers/search/id/{id}", method = RequestMethod.GET)
    public Customer getCustomerByPathId(@PathVariable String id){
        return customerDao.getCustomerById(id);
   }

    /**
     * Endpoint will return all customers in an alphabetic order.
     *
     * @return List<Customer> list of customers in JSON-format.
     */
   @RequestMapping(value = "/api/customers", method = RequestMethod.GET)
    public List<Customer> getCustomers(){
       return customerDao.getAllCustomers();
   }

    /**
     * Endpoint will return a subset of all customers.
     *
     * @return List<Customer> list of customers in JSON-format.
     */
    @RequestMapping(value ="/api/customers/subset/{limit}/{offset}", method = RequestMethod.GET)
    public List<Customer> getCustomerSubSet(@PathVariable String limit, @PathVariable String offset)  {
        return customerDao.getSubsetOfCustomers(limit, offset);
    }

    /**
     * Endpoint will return a customer searched by name.
     *
     * @param name is a PathVariable defined by the client
     * @return Customer object is returned with user information in a JSON-format.
     */
    @RequestMapping(value = "/api/customers/search/name/{name}", method = RequestMethod.GET)
    public Customer getCustomerByPathName(Model model, @PathVariable String name){
        return customerDao.getCustomerByName(name);
    }

    /**
     * Endpoint will insert a customer to the database.
     *
     * @param customer customer object defined as a JSON-body.
     * @return Customer that was inserted into the database.
     */
    @RequestMapping(value = "/api/insert/customers", method = RequestMethod.POST)
    public Customer insertCustomer(@RequestBody Customer customer){
        return customerDao.insertCustomer(customer);
    }

    /**
     * Endpoint will update a customer to the database.
     *
     * @param customer customer object defined as a JSON-body.
     * @return Customer that was updated in the database.
     */
    @RequestMapping(value = "/api/update/customers", method = RequestMethod.POST)
    public Customer updateCustomer(@RequestBody Customer customer){
        return customerDao.updateCustomer(customer);
    }

    /**
     * Endpoint will return number of customers in each country.
     *
     * @return List<CustomerCountry>
     */
    @RequestMapping(value = "/api/customers/groupByCountry", method = RequestMethod.GET)
    public List<CustomerCountry> getCustomerByCountry(){
        return customerDao.getCustomerByCountry();
    }

    /**
     * Endpoint will return the highest spenders of all customes.
     *
     * @return List<CustomerSpender>
     */
    @RequestMapping(value = "/api/customers/highestSpenders", method = RequestMethod.GET)
    public List<CustomerSpender>  getHighestSpender(){
        return customerDao.getHighestSpender();
    }

    /**
     * Endpoint will return the highest the most popular music genre for any given customer in the database.
     *
     * @return List<CustomerGenre>
     */
    @RequestMapping(value = "/api/customers/popular/genre/{id}", method = RequestMethod.GET)
    public List<CustomerGenre> getPopularGenre(@PathVariable int id){
        return customerDao.getPopularGenre(id);
    }

}
