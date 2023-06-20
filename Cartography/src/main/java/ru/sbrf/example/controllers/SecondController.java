package ru.sbrf.example.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.sbrf.example.domain.Album;
import ru.sbrf.example.domain.Group;
import ru.sbrf.example.service.CatalogService;

@Controller
@RequestMapping("/")
public class SecondController {

    @Autowired
    CatalogService catalogService;

    @GetMapping("/index")
    public String getAllGroups(Model model){
        model.addAttribute("allGroups", catalogService.getAllGroups());
        model.addAttribute("group", new Group());
        return "index";
    }

    @PostMapping("/index")
    public String putGroup(@ModelAttribute Group group){
        catalogService.putGroup(group);
        return "redirect:/index";
    }

    @GetMapping("/index/{groupId}")
    public String getGroup(@PathVariable int groupId, Model model){
        model.addAttribute("curGroup", catalogService.getGroup(groupId));
        return "groups";
    }

    @PostMapping("/index/{groupId}")
    public String putAlbum(@PathVariable int groupId, @ModelAttribute Album album){
        catalogService.putAlbum(groupId, album);
        return "redirect:/index" + groupId;
    }


}
