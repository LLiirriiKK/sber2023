package ru.sbrf.example.domain;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Album {
    private String albumName;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int albumId;
    private int albumYear;
    @OneToMany(mappedBy = "album", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Track> trackSet = new HashSet<>();
    @ManyToOne(fetch = FetchType.LAZY)
    private Group group;

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public void addTrack(Track track){
        trackSet.add(track);
        track.setAlbum(this);
    }

    public void removeTrack(Track track){
        trackSet.remove(track);
        track.setAlbum(null);
    }

    public Album(){}

    public Album(String albumName, int albumId, int albumYear, Set<Track> trackSet) {
        this.albumName = albumName;
        this.albumId = albumId;
        this.albumYear = albumYear;
        this.trackSet = trackSet;
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

    public Set<Track> getTrackSet() {
        return trackSet;
    }

    public void setTrackSet(Set<Track> trackSet) {
        this.trackSet = trackSet;
    }
}
