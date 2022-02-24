package com.example.javadatabaseproject.mappers;

import com.example.javadatabaseproject.models.Customer;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Aidin Ghassemloi och Richard Cruz.
 * Custom RowMapper class implementes RowMapper.
 * Class function maps the result set returned by JDBC-template as a list of objects.
 */
public class CustomerMapper implements RowMapper<Customer> {

    /**
     * Function iterates rowNum in the result set and sets its values to a new Customer object.
     *
     * @return Customer
     * @param rs result set from JDBC-template
     * @param rowNum amount of rows to iterate.
     */
    @Override
    public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
                    return new Customer(
                            rs.getInt("customerId"),
                            rs.getString("firstName"),
                            rs.getString("lastName"),
                            rs.getString("country"),
                            rs.getString("postalCode"),
                            rs.getString("phone"),
                            rs.getString("email")
                    );
    }
}
