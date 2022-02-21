package com.example.javadatabaseproject.mappers;


import com.example.javadatabaseproject.models.CustomerSpender;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class HighestSpenderMapper implements RowMapper<CustomerSpender> {

    @Override
    public CustomerSpender mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new CustomerSpender(
                rs.getString("FirstName"),
                rs.getString("LastName"),
                rs.getString("HighestSpender")
        );
    }
}
