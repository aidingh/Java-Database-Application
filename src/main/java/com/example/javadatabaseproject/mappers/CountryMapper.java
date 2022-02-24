package com.example.javadatabaseproject.mappers;

import com.example.javadatabaseproject.models.CustomerCountry;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Aidin Ghassemloi och Richard Cruz.
 * Custom RowMapper class implementes RowMapper.
 * Class function maps the result set returned by JDBC-template as a list of objects.
 */
public class CountryMapper implements RowMapper<CustomerCountry> {

    /**
     * Function iterates rowNum in the result set and sets its values to a new CustomerCountry object.
     *
     * @return CustomerCountry
     * @param rs result set from JDBC-template
     * @param rowNum amount of rows to iterate.
     */
    @Override
    public CustomerCountry mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new CustomerCountry(
                rs.getString("Country"),
                rs.getInt("NumberOfCountries")
        );
    }
}
