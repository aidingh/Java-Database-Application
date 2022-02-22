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
    public List<Artists> getArtistData() {

        String clause = "Cochise";

        String query = "SELECT ART.Name AS artistName, Al.Title AS titleName, Track.Name AS trackName , G.Name AS genreName FROM Track " +
                "INNER JOIN Genre G ON Track.GenreId = G.GenreId " +
                "INNER JOIN Album Al ON Track.TrackId = AL.AlbumId " +
                "INNER JOIN Artist ART ON AL.AlbumId  = ART.ArtistId " +
                "WHERE Track.Name = ?";
        return this.jdbcTemplate.query(query, new ArtistMapper(), clause);
    }
}