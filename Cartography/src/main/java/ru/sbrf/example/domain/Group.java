package ru.sbrf.example.domain;

import java.util.List;

public class Group {
    private String nameGroup;
    private int groupId;
    private List<Album> albumList;

    public Group(){}

    public Group(String nameGroup, int groupId, List<Album> albumList) {
        this.nameGroup = nameGroup;
        this.groupId = groupId;
        this.albumList = albumList;
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

    public List<Album> getAlbumList() {
        return albumList;
    }

    public void setAlbumList(List<Album> albumList) {
        this.albumList = albumList;
    }
}
