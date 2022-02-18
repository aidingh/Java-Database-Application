package com.example.javadatabaseproject;
import java.sql.*;

import ConnectionManagers.ConnectionManager;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JavaDatabaseProjectApplication {
    static final String getCustomerQUERYAll = "SELECT * FROM customer";
    static final String getCustomerQUERY = "SELECT CustomerId, FirstName, LastName, Country, PostalCode, Phone, Email FROM customer";
    static final String getCustomerByIdQUERY = "SELECT CustomerId, FirstName, LastName, Country, PostalCode, Phone, Email FROM customer";

    public static void main(String[] args) throws SQLException {

        //SpringApplication.run(JavaDatabaseProjectApplication.class, args);

        ConnectionManager connectionManager = new ConnectionManager();
        connectionManager.connectManager();
        connectionManager.runSqlCommand(getCustomerQUERY);
        connectionManager.printTable();

        }
}
