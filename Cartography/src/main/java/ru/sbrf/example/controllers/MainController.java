package ru.sbrf.example.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.sbrf.example.domain.Album;
import ru.sbrf.example.domain.Group;
import ru.sbrf.example.domain.Track;
import ru.sbrf.example.service.CatalogService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MainController {

    @Autowired
    private CatalogService catalogService;

    @PostMapping("/groups")
    public Group putGroup(@RequestBody Group group) {
        return catalogService.putGroup(group);
    }


    @GetMapping("/groups/{groupId}")
    public Group getGroup(@PathVariable int groupId) {
        return catalogService.getGroup(groupId);
    }

    @GetMapping("/groups")
    public List<Group> getAllGroups() {
        return catalogService.getAllGroups();
    }

    @GetMapping("/groups/{groupId}/albums")
    public List<Album> getAllAlbums(@PathVariable int groupId) {
        return catalogService.getAllAlbumsByGroup(groupId);
    }

    @GetMapping("/groups/{groupId}/albums/{albumId}")
    public Album getAlbum(@PathVariable int groupId, @PathVariable int albumId) {
        return catalogService.getAlbum(groupId, albumId);
    }

    @PostMapping("/groups/{groupId}/albums")
    public Album putAlbum(@PathVariable int groupId, @RequestBody Album album) {
        catalogService.putAlbum(groupId, album);
        return album;
    }

    @GetMapping("/groups/{groupId}/albums/{albumId}/tracks")
    public List<Track> getAllTracks(@PathVariable int groupId, @PathVariable int albumId) {
        return catalogService.getAllTracksByAlbum(groupId, albumId);
    }

    @GetMapping("/groups/{groupId}/albums/{albumId}/tracks/{trackId}")
    public Track getTrack(@PathVariable int groupId, @PathVariable int albumId, @PathVariable int trackId) {
        return catalogService.getTrack(groupId, albumId, trackId);

    }

    @PostMapping("/groups/{groupId}/albums/{albumId}/tracks")
    public Track putTrack(@PathVariable int groupId, @PathVariable int albumId, @RequestBody Track track) {
        return catalogService.putTrack(groupId, albumId, track);
    }


}
