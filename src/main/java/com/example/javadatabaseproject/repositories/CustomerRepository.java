package com.example.javadatabaseproject.repositories;

import com.example.javadatabaseproject.ConnectionManagers.ConnectionManager;
import com.example.javadatabaseproject.models.Customer;

import java.sql.*;
import java.util.ArrayList;

public class CustomerRepository {

    ConnectionManager connectionManager = new ConnectionManager();


    public void establishConnection() throws SQLException {
        connectionManager.connectManager();
           }

    public ArrayList<Customer> getAllCustomers() throws SQLException {
        connectionManager.
                runSqlCommand("SELECT CustomerId, FirstName, LastName, Country, PostalCode, Phone, Email FROM customer");
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

    public boolean addNewCustomer(Customer customer) throws SQLException{
     connectionManager.
             runUpdateSqlCommand("INSERT INTO customer(CustomerId, FirstName, LastName, Country, PostalCode, Phone, Email) VALUES (?,?,?,?,?,?,?)");

        connectionManager.prepStatement.setInt(1, customer.getCustomerId());
        connectionManager.prepStatement.setString(2, customer.getFirstName());
        connectionManager.prepStatement.setString(3, customer.getLastName());
        connectionManager.prepStatement.setString(4, customer.getCountry());
        connectionManager.prepStatement.setString(5, customer.getPostalCode());
        connectionManager.prepStatement.setString(6, customer.getPhone());
        connectionManager.prepStatement.setString(7, customer.getEmail());

        int result = connectionManager.prepStatement.executeUpdate();
        boolean succeeded = false;

        if(result != 0)
            succeeded = true;
        System.out.println("VALUE: "+succeeded);

      return  succeeded;
    }

}
