package com.example.javadatabaseproject.mappers;


import com.example.javadatabaseproject.models.CustomerCountry;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CountryMapper implements RowMapper<CustomerCountry> {

    @Override
    public CustomerCountry mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new CustomerCountry(
                rs.getString("Country"),
                rs.getInt("NumberOfCountries")
        );
    }
}
