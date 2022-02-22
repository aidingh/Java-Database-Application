package com.example.javadatabaseproject.models;

public class Artists {

    public String trackName;
    public String artists;
    public String album;
    public String genres;

    public Artists(String trackName, String artists, String album, String genres) {
        this.trackName = trackName;
        this.artists = artists;
        this.album = album;
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

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getGenres() {
        return genres;
    }

    public void setGenres(String genres) {
        this.genres = genres;
    }
}
