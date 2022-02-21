package com.example.javadatabaseproject.models;

import java.util.List;

public interface CustomerDao{
    List<Customer> getAllCustomers();
    Customer getCustomerById(String id);
    Customer getCustomerByName(String name);
    List<Customer> getSubsetOfCustomers(String limit, String offset);
    int insertCustomer(Customer customer);
    int deleteCustomer(int id);
}
