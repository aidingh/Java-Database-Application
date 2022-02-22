package com.example.javadatabaseproject.repositories;

import com.example.javadatabaseproject.access.layer.CustomerDao;
import com.example.javadatabaseproject.models.*;
import com.example.javadatabaseproject.mappers.CountryMapper;
import com.example.javadatabaseproject.mappers.HighestSpenderMapper;
import com.example.javadatabaseproject.mappers.PopularGenreMapper;
import com.example.javadatabaseproject.mappers.CustomerMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class CustomerRepository implements CustomerDao {

    public final String attributes =  "CustomerId, FirstName, LastName, Country, PostalCode, Phone, Email";
    public JdbcTemplate jdbcTemplate;

    public CustomerRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Customer> getAllCustomers() {
        String query = "SELECT CustomerId, FirstName, LastName, Country, PostalCode, Phone, Email FROM customer ORDER BY FirstName";
        return this.jdbcTemplate.query(query, new CustomerMapper());
    }

    @Override
    public Customer getCustomerById(String id) {
        String query = "SELECT " + attributes + " FROM customer WHERE CustomerId" + "=" + id;
        return this.jdbcTemplate.queryForObject(query, new CustomerMapper());
    }

    @Override
    public Customer getCustomerByName(String name) {
        String query = "SELECT " + attributes + " FROM customer " +
                "WHERE FirstName LIKE " +"'%" + name + "%'";
        return this.jdbcTemplate.queryForObject(query, new CustomerMapper());
    }

    @Override
    public List<Customer> getSubsetOfCustomers(String limit, String offset) {

        StringBuilder sql = new StringBuilder();
        sql.append("SELECT CustomerId, FirstName, LastName, Country, PostalCode, Phone, Email FROM customer ");
        if (Integer.parseInt(limit) > 0) {
            sql.append("LIMIT ");
            if (Integer.parseInt(offset) > 0) {
                sql.append(offset);
                sql.append(", ");
            }
            sql.append(limit);
            sql.append(" ");
        }
        return this.jdbcTemplate.query(sql.toString(), new CustomerMapper());
    }

    @Override
    public Customer insertCustomer(Customer customer) {
       String query = "INSERT INTO customer(CustomerId, FirstName, LastName, Country, PostalCode, Phone, Email) VALUES (?,?,?,?,?,?,?)";
       this.jdbcTemplate.update(query, customer.customerId, customer.firstName,customer.lastName,customer.country, customer.postalCode,customer.phone,customer.email);
       return customer;
    }

    @Override
    public Customer updateCustomer(Customer customer) {
        String query = "UPDATE customer " +
                       "SET FirstName=?, LastName=?, Country=?, PostalCode=?, Phone=?, Email=? " +
                       "WHERE CustomerId = ?";

       this.jdbcTemplate.update(query, customer.firstName,customer.lastName,customer.country, customer.postalCode,customer.phone,customer.email, customer.customerId);
       return customer;
    }

    @Override
    public List<CustomerCountry> getCustomerByCountry() {
        String query = "SELECT Country, COUNT(*) AS NumberOfCountries " +
                       "FROM Customer " +
                       "GROUP BY Country " +
                       "ORDER BY NumberOfCountries DESC;";
        return this.jdbcTemplate.query(query, new CountryMapper());
    }

    @Override
    public List<CustomerSpender> getHighestSpender() {
        String query = "SELECT FirstName, LastName, SUM(Invoice.Total) AS HighestSpender " +
                       "FROM  Customer " +
                       "INNER JOIN Invoice ON Customer.CustomerId = Invoice.InvoiceId " +
                       "GROUP BY Customer.CustomerId " +
                       "ORDER BY HighestSpender DESC;";
        return this.jdbcTemplate.query(query, new HighestSpenderMapper());
    }

    @Override
    public List<CustomerGenre> getPopularGenre(int id) {
        String query = "WITH POPULAR_CUSTOMER AS ( " +
                             "SELECT C.FirstName, C.LastName, g.Name, COUNT(T.TrackId) AS QUANTITY " +
                             "FROM Customer C " +
                                    "INNER JOIN Invoice I on C.CustomerId = I.CustomerId " +
                                    "INNER JOIN InvoiceLine IL on I.InvoiceId = IL.InvoiceId " +
                                    "INNER JOIN Track T on IL.TrackId = T.TrackId " +
                                    "INNER JOIN Genre G on T.GenreId = G.GenreId " +
                             "WHERE C.CustomerId = ? " +
                             "GROUP BY G.GenreId " +
                                ") " +
                             "SELECT POPULAR_CUSTOMER.* " +
                             "FROM POPULAR_CUSTOMER " +
                             "WHERE POPULAR_CUSTOMER.QUANTITY = (SELECT max(POPULAR_CUSTOMER.QUANTITY) FROM POPULAR_CUSTOMER);";

        return this.jdbcTemplate.query(query, new PopularGenreMapper(),id);
    }


}