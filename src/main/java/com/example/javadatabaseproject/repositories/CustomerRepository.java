package com.example.javadatabaseproject.repositories;

import com.example.javadatabaseproject.models.Customer;

import java.sql.*;
import java.util.ArrayList;

public class CustomerRepository {
    public Connection driverConnection;
    private static final String URL = "jdbc:sqlite::resource:Chinook_Sqlite.sqlite";


    public ArrayList<Customer> getAllCustomer(){
        ArrayList<Customer> customers = new ArrayList<>();

        try {

            driverConnection = DriverManager.getConnection(URL);
            PreparedStatement prepStatement = driverConnection.
                    prepareStatement("SELECT CustomerId, FirstName, LastName, Country, PostalCode, Phone, Email FROM customer");

            ResultSet rs = prepStatement.executeQuery();

            while (rs.next()){
                customers.add(
                        new Customer(
                                rs.getInt("customerId"),
                                rs.getString("lastName"),
                                rs.getString("lastName"),
                                rs.getString("country"),
                                rs.getString("postalCode"),
                                rs.getString("phone"),
                                rs.getString("email")
                                    )
                            );
                          }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        finally {
            try{
                driverConnection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
      return customers;
    }

}
