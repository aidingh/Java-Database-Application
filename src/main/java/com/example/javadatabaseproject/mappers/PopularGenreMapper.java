package com.example.javadatabaseproject.mappers;


import com.example.javadatabaseproject.models.CustomerGenre;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PopularGenreMapper implements RowMapper<CustomerGenre> {

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
