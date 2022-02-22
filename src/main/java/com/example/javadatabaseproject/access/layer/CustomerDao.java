package com.example.javadatabaseproject.access.layer;

import com.example.javadatabaseproject.models.Customer;
import com.example.javadatabaseproject.models.CustomerCountry;
import com.example.javadatabaseproject.models.CustomerGenre;
import com.example.javadatabaseproject.models.CustomerSpender;

import java.util.List;

public interface CustomerDao{
    List<Customer> getAllCustomers();
    Customer getCustomerById(String id);
    Customer getCustomerByName(String name);
    List<Customer> getSubsetOfCustomers(String limit, String offset);
    Customer insertCustomer(Customer customer);
    Customer updateCustomer(Customer customer);
    List<CustomerCountry> getCustomerByCountry();
    List<CustomerSpender> getHighestSpender();
    List<CustomerGenre> getPopularGenre(int id);
}
