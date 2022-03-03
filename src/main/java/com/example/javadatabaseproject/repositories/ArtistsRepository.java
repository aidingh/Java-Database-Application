package com.example.javadatabaseproject.repositories;

import com.example.javadatabaseproject.access.layer.ArtistDao;
import com.example.javadatabaseproject.mappers.ArtistMapper;
import com.example.javadatabaseproject.models.Artists;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * @author Aidin Ghassemloi och Richard Cruz.
 * Repository class implmenets artist data access object.
 * Class is responseble for handeling querys and map the results back to the controller class.
 */

@Repository
public class ArtistsRepository implements ArtistDao {

    public JdbcTemplate jdbcTemplate;

    public ArtistsRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    /**
     * Function executes the local query defined in the function and RowMaps its results with a custom mapper.
     * Custom mapper : ArtistMapper
     *
     * @param keyWord search string containing the track searched by the client.
     * @return List<Artists>
     */
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
                     "WHERE Track.Name LIKE " +"'%" + keyWord + "%'"  ;
        return this.jdbcTemplate.query(query, new ArtistMapper());
    }

    /**
     * Function executes the local query defined in the function and RowMaps its results with a custom mapper.
     * Function will return a list of Artists. But the query defines random artists and displayed to the client.
     * Custom mapper : ArtistMapper
     *
     * @return List<Artists>
     */
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
