package com.example.javadatabaseproject;
import java.sql.*;

import com.example.javadatabaseproject.ConnectionManagers.ConnectionManager;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JavaDatabaseProjectApplication {
    static final String getCustomerQUERYAll = "SELECT * FROM customer";
    static final String getCustomerQUERY = "SELECT CustomerId, FirstName, LastName, Country, PostalCode, Phone, Email FROM customer";

    static final String customerID = "59";
    static final String name = "Srivastava";

    static final String getCustomerByIdQUERY = "SELECT CustomerId, FirstName, LastName, Country, PostalCode, Phone, Email FROM customer WHERE CustomerId" + "=" + customerID;
    static final String getCustomerByNameQUERY = "SELECT CustomerId, FirstName, LastName, Country, PostalCode, Phone, Email FROM customer WHERE FirstName=" + name + "LIKE '\"%DT%\"'";
    public static void main(String[] args) throws SQLException {

        SpringApplication.run(JavaDatabaseProjectApplication.class, args);

        ConnectionManager connectionManager = new ConnectionManager();
        connectionManager.connectManager();
        connectionManager.runSqlCommand(getCustomerByIdQUERY);
        connectionManager.printTable();

        }
}
