package ru.sbrf.example.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.sbrf.example.domain.Album;
import ru.sbrf.example.domain.Group;
import ru.sbrf.example.domain.Track;
import ru.sbrf.example.repository.AlbumRepository;
import ru.sbrf.example.repository.GroupRepository;
import ru.sbrf.example.repository.TrackRepository;
import ru.sbrf.example.service.CatalogService;

@Controller
@RequestMapping("/")
public class SecondController {

//    @Autowired
//    CatalogService catalogService;
    GroupRepository groupRepository;
    AlbumRepository albumRepository;
    TrackRepository trackRepository;

    @Autowired
    public SecondController(GroupRepository groupRepository, AlbumRepository albumRepository, TrackRepository trackRepository) {
        this.groupRepository = groupRepository;
        this.albumRepository = albumRepository;
        this.trackRepository = trackRepository;
    }

    @GetMapping("/index")
    public String getAllGroups(Model model){
//        model.addAttribute("allGroups", catalogService.getAllGroups());
        model.addAttribute("allGroups", groupRepository.findAll());
        return "index";
    }

    @PostMapping("/index")
    public String putGroup(@ModelAttribute Group group){
//        catalogService.putGroup(group);
        groupRepository.save(group);
        return "redirect:/index";
    }

    @GetMapping("/index/{groupId}")
    public String getGroup(@PathVariable int groupId, Model model){
//        model.addAttribute("curGroup", catalogService.getGroup(groupId));
//        model.addAttribute("albumList", catalogService.getGroup(groupId).getAlbumSet());
        model.addAttribute("curGroup", groupRepository.getReferenceById(groupId));
        model.addAttribute("albumList", groupRepository.getReferenceById(groupId).getAlbumSet().stream().toList());
        return "groups";
    }

    @PostMapping("/index/{groupId}")
    public String putAlbum(@PathVariable int groupId, @ModelAttribute Album album){
//        catalogService.putAlbum(groupId, album);
        Group group = groupRepository.getReferenceById(groupId);
        group.addAlbum(album);
        albumRepository.save(album);
        return "redirect:/index/" + groupId;
    }

    @GetMapping("/index/{groupId}/albums/{albumId}")
    public String getAlbum(@PathVariable int groupId, @PathVariable int albumId, Model model){
        model.addAttribute("curGroup", groupRepository.getReferenceById(groupId));
        model.addAttribute("curAlbum", albumRepository.getReferenceById(albumId));
        model.addAttribute("trackList", albumRepository.getReferenceById(albumId).getTrackSet().stream().toList());
        return "albums";
    }

    @PostMapping("/index/{groupId}/albums/{albumId}")
    public String putTrack(@PathVariable int groupId, @PathVariable int albumId, @ModelAttribute Track track){
        Album album = albumRepository.getReferenceById(albumId);
        album.addTrack(track);
        trackRepository.save(track);
        return "redirect:/index/" + groupId + "/albums/" + albumId;
    }

    @GetMapping("/index/{groupId}/albums/{albumId}/tracks/{trackId}")
    public String getTrack(@PathVariable int groupId, @PathVariable int albumId, @PathVariable int trackId, Model model){
        model.addAttribute("curGroup", groupRepository.getReferenceById(groupId));
        model.addAttribute("curAlbum", albumRepository.getReferenceById(albumId));
        model.addAttribute("curTrack", trackRepository.getReferenceById(trackId));
        return "tracks";
    }
    @PostMapping("/index/{groupId}/albums/{albumId}/tracks/{trackId}")
    public String putDuration(@PathVariable int groupId, @PathVariable int albumId, @PathVariable int trackId, @RequestParam(name = "duration") int duration){
        Track myTrack = trackRepository.getReferenceById(trackId);
        myTrack.setDuration(duration);
        trackRepository.save(myTrack);
        return "redirect:/index/"+ groupId +"/albums/"+ albumId+"/tracks/"+ trackId;
    }


}
