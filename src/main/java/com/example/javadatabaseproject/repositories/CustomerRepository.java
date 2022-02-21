package com.example.javadatabaseproject.repositories;

import com.example.javadatabaseproject.ConnectionManagers.ConnectionManager;
import com.example.javadatabaseproject.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;

@Repository
public class CustomerRepository{

    ConnectionManager connectionManager = new ConnectionManager();

    public CustomerRepository() {
        this.establishConnection();
    }

    public void establishConnection(){
        connectionManager.connectManager();
    }

    public void runSql(String QUERY) throws SQLException {
        connectionManager.prepareSqlQuery(QUERY);
    }

    public ArrayList<Customer> getAllCustomers() throws SQLException {
        ArrayList<Customer> customers = new ArrayList<>();
        while (connectionManager.set.next()){
            customers.add(
                    new Customer(
                            connectionManager.set.getInt("customerId"),
                            connectionManager.set.getString("firstName"),
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

    public Customer getCustomerById() throws SQLException {

        Customer tempCustomer = null;
        while (connectionManager.set.next()) {
            tempCustomer = new Customer(
                    connectionManager.set.getInt("customerId"),
                    connectionManager.set.getString("firstName"),
                    connectionManager.set.getString("lastName"),
                    connectionManager.set.getString("country"),
                    connectionManager.set.getString("postalCode"),
                    connectionManager.set.getString("phone"),
                    connectionManager.set.getString("email")
            );

        }
        return tempCustomer;
    }

}
