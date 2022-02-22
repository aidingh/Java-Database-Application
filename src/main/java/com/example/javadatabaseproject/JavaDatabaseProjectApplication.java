package com.example.javadatabaseproject;
import java.sql.*;

import com.example.javadatabaseproject.connection.managers.ConnectionManager;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication

public class JavaDatabaseProjectApplication {
    static final String getCustomerQUERYAll = "SELECT * FROM customer";
    static final String getCustomerQUERY = "SELECT CustomerId, FirstName, LastName, Country, PostalCode, Phone, Email FROM customer ORDER BY FirstName";

    static final String customerID = "59";
    static final String name = "Steve";

    static final String getCustomerByIdQUERY = "SELECT CustomerId, FirstName, LastName, Country, PostalCode, Phone, Email FROM customer WHERE CustomerId" + "=" + customerID;
    static final String getCustomerByNameQUERY = "SELECT CustomerId, FirstName, LastName, Country, PostalCode, Phone, Email FROM customer " +
            "WHERE FirstName LIKE " +"'%" + name + "%'";

    static final String limit = "10";
    static final String offset = "50";
    static final String attributes =  "CustomerId, FirstName, LastName, Country, PostalCode, Phone, Email";
    static final String getCustomerOffsetQUERY = "SELECT " + attributes +
            " FROM customer ORDER BY FirstName LIMIT " + limit + " OFFSET " + offset;

    static final String trackQuery = "SELECT name FROM Track";
    public static void main(String[] args) throws SQLException {

        SpringApplication.run(JavaDatabaseProjectApplication.class, args);

        ConnectionManager connectionManager = new ConnectionManager();
        connectionManager.connectManager();
        connectionManager.prepareSqlQuery(trackQuery);
        connectionManager.printTable();

        }
}
