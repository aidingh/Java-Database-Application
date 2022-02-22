package com.example.javadatabaseproject.repositories;

import com.example.javadatabaseproject.access.layer.ArtistDao;
import com.example.javadatabaseproject.mappers.ArtistMapper;
import com.example.javadatabaseproject.models.Artists;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class ArtistsRepository implements ArtistDao {

    public JdbcTemplate jdbcTemplate;

    public ArtistsRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Artists> getArtistData(String keyWord) {

        String query = "SELECT Track.Name AS trackName, " +
                              "A2.Name AS artistName, " +
                              "A.Title AS titleName, " +
                              "G.Name AS genreName " +
                        "FROM Track " +
                     "INNER JOIN Genre G on G.GenreId = Track.GenreId " +
                     "INNER JOIN Album A on A.AlbumId = Track.AlbumId " +
                     "INNER JOIN Artist A2 on A2.ArtistId = A.ArtistId " +
                     "WHERE Track.Name = ? ";
        return this.jdbcTemplate.query(query, new ArtistMapper(), keyWord);
    }

    @Override
    public List<Artists> getMusicData() {
        String query = "SELECT Track.Name AS trackName, " +
                "A2.Name AS artistName, " +
                "A.Title AS titleName, " +
                "G.Name AS genreName " +
                "FROM Track " +
                "INNER JOIN Genre G on G.GenreId = Track.GenreId " +
                "INNER JOIN Album A on A.AlbumId = Track.AlbumId " +
                "INNER JOIN Artist A2 on A2.ArtistId = A.ArtistId " +
                "ORDER BY random() LIMIT 5";

       return this.jdbcTemplate.query(query, new ArtistMapper());
    }
}
