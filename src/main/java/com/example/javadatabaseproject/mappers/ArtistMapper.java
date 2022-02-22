package com.example.javadatabaseproject.mappers;

import com.example.javadatabaseproject.models.Artists;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ArtistMapper implements RowMapper<Artists> {

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
