package ru.sbrf.example.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import ru.sbrf.example.domain.Album;
import ru.sbrf.example.domain.Group;
import ru.sbrf.example.domain.Track;

import java.util.ArrayList;
import java.util.List;

@Component
public class CatalogService {

    private List<Group> allGroups = new ArrayList<>();

        public Group putGroup(Group group){
            allGroups.add(group);
            return group;
        }

        public Group getGroup(int id) {
            for (Group group : allGroups) {
                if (id == group.getGroupId()) {
                    return group;
                }
            }
            return null;
        }

        public List<Group> getAllGroups(){
            return allGroups;
        }


        public List<Album> getAllAlbumsByGroup(int groupId){
            return getGroup(groupId).getAlbumList();
        }

        public Album getAlbum(int groupId, int albumId){
            Group group = getGroup(groupId);

            for (Album album: group.getAlbumList()){
                if (albumId == album.getAlbumId()){
                    return album;
                }
            }
            return null;
        }

        public Album putAlbum(int groupId, Album album){
            List<Album> albums = getAllAlbumsByGroup(groupId);
            albums.add(album);
            return album;
        }

        public List<Track> getAllTracksByAlbum(int groupId, int albumId){
            return getAlbum(groupId, albumId).getTrackList();
        }

        public Track getTrack(int groupId, int albumId, int trackId){
            Album album = getAlbum(groupId, albumId);
            for (Track track: album.getTrackList()){
                if (trackId == track.getTrackId()){
                    return track;
                }
            }
            return null;
        }

        public Track putTrack(int groupId, int albumId, Track track){
            List<Track> tracks = getAllTracksByAlbum(groupId, albumId);
            tracks.add(track);
            return track;
        }

}
