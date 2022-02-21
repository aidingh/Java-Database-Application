package com.example.javadatabaseproject.repositories;

import com.example.javadatabaseproject.models.Customer;
import com.example.javadatabaseproject.models.CustomerDao;
import mappers.CustomerRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class CustomerDataAccessService implements CustomerDao {

    public final String attributes =  "CustomerId, FirstName, LastName, Country, PostalCode, Phone, Email";
    public JdbcTemplate jdbcTemplate;

    public CustomerDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Customer> getAllCustomers() {
        String query = "SELECT CustomerId, FirstName, LastName, Country, PostalCode, Phone, Email FROM customer ORDER BY FirstName";
        return this.jdbcTemplate.query(query, new CustomerRowMapper());
    }

    @Override
    public Customer getCustomerById(String id) {
        String query = "SELECT " + attributes + " FROM customer WHERE CustomerId" + "=" + id;
        return this.jdbcTemplate.queryForObject(query, new CustomerRowMapper());
    }

    @Override
    public Customer getCustomerByName(String name) {
        String query = "SELECT " + attributes + " FROM customer " +
                "WHERE FirstName LIKE " +"'%" + name + "%'";
        return this.jdbcTemplate.queryForObject(query, new CustomerRowMapper());
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
        return this.jdbcTemplate.query(sql.toString(), new CustomerRowMapper());
    }

    @Override
    public int insertCustomer(Customer customer) {
        return 0;
    }

    @Override
    public int deleteCustomer(int id) {
        return 0;
    }
}
