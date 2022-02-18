package com.example.javadatabaseproject;
import java.sql.*;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JavaDatabaseProjectApplication {
    static final String getCustomerQUERYAll = "SELECT * FROM customer";
    static final String getCustomerQUERY = "SELECT CustomerId, FirstName, LastName, Country, PostalCode, Phone, Email FROM customer";
    static final String getCustomerByIdQUERY = "SELECT CustomerId, FirstName, LastName, Country, PostalCode, Phone, Email FROM customer";
   /*public static String URL = "jdbc:sqlite::resource:Chinook_Sqlite.sqlite";
    static final String QUERY = "SELECT trackId FROM track";
    static final String QUERY2 = "SELECT Customer.CustomerId, Customer.firstname, Customer.lastname, Customer.company, Customer.city, Invoice.CustomerId, Invoice.BillingCity" +
            "    FROM Customer" +
            "    JOIN Invoice" +
            "    ON Invoice.CustomerId = Customer.CustomerId" +
            "    ORDER BY Customer.CustomerId";
    static final String QUERY3 = "SELECT " +
            "TrackId," +
            "name," +
            "composer," +
            "unitprice" +
            "FROM" +
            "tracks;";*/
    public static void main(String[] args) throws SQLException {

        SpringApplication.run(JavaDatabaseProjectApplication.class, args);

        //ConnectionManager connectionManager = new ConnectionManager();
        //connectionManager.connectManager();
        //connectionManager.runSqlCommand(getCustomerQUERY);
        //connectionManager.printTable();

        //connectionManager.connectManager();
        //connectionManager.runSqlCommand(getCustomerQUERYAll);
        //connectionManager.printTable();

        // Open a connection
       /* try(Connection conn = DriverManager.getConnection(URL)){
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(QUERY);

           // rs.getObject("FirstName");
            while (rs.next()) {
                for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
                    if (i > 1) System.out.print(",  ");
                    String columnValue = rs.getString(i);
                    System.out.print(columnValue + " " + rs.getMetaData().getColumnName(i));
                }
                System.out.println("");
            }

            /*while (rs.next()) {
                // Retrieve by column name
                System.out.println(rs.getInt("trackId"));
                //System.out.print(", name: " + rs.getString("FirstName"));
                //System.out.print(", lastname: " + rs.getString("LastName"));
                //System.out.println(", city: " + rs.getString("City"));
            }*/
        }
}
