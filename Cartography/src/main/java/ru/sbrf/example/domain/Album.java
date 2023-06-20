package ru.sbrf.example.domain;

import java.util.List;

public class Album {
    private String albumName;
    private int albumId;
    private int albumYear;
    private List<Track> trackList;

    public Album(){}

    public Album(String albumName, int albumId, int albumYear, List<Track> trackList) {
        this.albumName = albumName;
        this.albumId = albumId;
        this.albumYear = albumYear;
        this.trackList = trackList;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public int getAlbumId() {
        return albumId;
    }

    public void setAlbumId(int albumId) {
        this.albumId = albumId;
    }

    public int getAlbumYear() {
        return albumYear;
    }

    public void setAlbumYear(int albumYear) {
        this.albumYear = albumYear;
    }

    public List<Track> getTrackList() {
        return trackList;
    }

    public void setTrackList(List<Track> trackList) {
        this.trackList = trackList;
    }
}
