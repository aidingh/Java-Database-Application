package com.example.javadatabaseproject.models;

public class Music {

    public String trackName;
    public String artists;
    public String genres;

    public Music(String trackName, String artists, String genres) {
        this.trackName = trackName;
        this.artists = artists;
        this.genres = genres;
    }

    public String getTrackName() {
        return trackName;
    }

    public void setTrackName(String trackName) {
        this.trackName = trackName;
    }

    public String getArtists() {
        return artists;
    }

    public void setArtists(String artists) {
        this.artists = artists;
    }

    public String getGenres() {
        return genres;
    }

    public void setGenres(String genres) {
        this.genres = genres;
    }
}
