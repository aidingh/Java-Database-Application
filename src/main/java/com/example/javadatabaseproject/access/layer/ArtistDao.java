package com.example.javadatabaseproject.access.layer;

import com.example.javadatabaseproject.models.*;
import java.util.List;

/**
 * @author Aidin Ghassemloi och Richard Cruz.
 * Data access objects for artists. Implemented by ArtistRepository class.
 */
public interface ArtistDao{
    List<Artists> getArtistData(String keyWord);
    List<Artists> getMusicData();
}
