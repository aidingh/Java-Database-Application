package com.example.javadatabaseproject.mappers;

import com.example.javadatabaseproject.models.Music;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MusicMapper implements RowMapper<Music> {

    @Override
    public Music mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Music(
                rs.getString("TrackName"),
                rs.getString("titleName"),
                rs.getString("genreName")
        );
    }
}
