package com.example.javadatabaseproject.mappers;

import com.example.javadatabaseproject.models.Artists;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Aidin Ghassemloi och Richard Cruz.
 * Custom RowMapper class implementes RowMapper.
 * Class function maps the result set returned by JDBC-template as a list of objects.
 */
public class ArtistMapper implements RowMapper<Artists> {

    /**
     * Function maps the result set returned by JDBC-template as a list of objects.
     * Function iterates rowNum in the result set and sets its values to a new Artists object.
     *
     * @return Artists
     * @param rs result set from JDBC-template
     * @param rowNum amount of rows to iterate.
     */
    @Override
    public Artists mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Artists(
                rs.getString("trackName"),
                rs.getString("artistName"),
                rs.getString("titleName"),
                rs.getString("genreName")
        );
    }
}
