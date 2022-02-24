package com.example.javadatabaseproject.mappers;


import com.example.javadatabaseproject.models.CustomerGenre;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Aidin Ghassemloi och Richard Cruz.
 * Custom RowMapper class implementes RowMapper.
 * Class function maps the result set returned by JDBC-template as a list of objects.
 */
public class PopularGenreMapper implements RowMapper<CustomerGenre> {

    /**
     * Function iterates rowNum in the result set and sets its values to a new CustomerGenre object.
     *
     * @return CustomerGenre
     * @param rs result set from JDBC-template
     * @param rowNum amount of rows to iterate.
     */
    @Override
    public CustomerGenre mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new CustomerGenre(
                rs.getString("FirstName"),
                rs.getString("LastName"),
                rs.getString("Name"),
                rs.getString("QUANTITY")

        );
    }
}
