package ru.sbrf.example.domain;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "groupTable")
public class Group {
    private String nameGroup;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int groupId;
    @OneToMany(mappedBy = "group", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Album> albumSet = new HashSet<>();

    public Group(){}

    public Group(String nameGroup, int groupId, Set<Album> albumSet) {
        this.nameGroup = nameGroup;
        this.groupId = groupId;
        this.albumSet = albumSet;
    }

    public void addAlbum(Album album){
        albumSet.add(album);
        album.setGroup(this);
    }

    public void removeAlbum(Album album){
        albumSet.remove(album);
        album.setGroup(null);
    }


    public String getNameGroup() {
        return nameGroup;
    }

    public void setNameGroup(String nameGroup) {
        this.nameGroup = nameGroup;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public Set<Album> getAlbumSet() {
        return albumSet;
    }

    public void setAlbumSet(Set<Album> albumSet) {
        this.albumSet = albumSet;
    }
}
