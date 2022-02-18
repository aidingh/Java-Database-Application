package com.example.javadatabaseproject.repositories;

import com.example.javadatabaseproject.ConnectionManagers.ConnectionManager;
import com.example.javadatabaseproject.models.Customer;

import java.sql.*;
import java.util.ArrayList;

public class CustomerRepository {

    ConnectionManager connectionManager = new ConnectionManager();


    public void establishConnection() throws SQLException {
        connectionManager.connectManager();
        connectionManager.runSqlCommand("SELECT CustomerId, FirstName, LastName, Country, PostalCode, Phone, Email FROM customer");
    }

    public ArrayList<Customer> getAllCustomers() throws SQLException {
        ArrayList<Customer> customers = new ArrayList<>();
        while (connectionManager.set.next()){
            customers.add(
                    new Customer(
                            connectionManager.set.getInt("customerId"),
                            connectionManager.set.getString("lastName"),
                            connectionManager.set.getString("lastName"),
                            connectionManager.set.getString("country"),
                            connectionManager.set.getString("postalCode"),
                            connectionManager.set.getString("phone"),
                            connectionManager.set.getString("email")
                    )
            );
        }
        return customers;
    }
}
