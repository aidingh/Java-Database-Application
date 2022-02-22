package com.example.javadatabaseproject.controllers.rest;


import com.example.javadatabaseproject.access.layer.ArtistDao;
import com.example.javadatabaseproject.models.Artists;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class ArtistsController {

    private final ArtistDao artistDao;

    public ArtistsController(ArtistDao artistDao) {
        this.artistDao = artistDao;
    }

    @RequestMapping(path = {"/home","/search"})
    public String home(Model model, String keyword) {
        model.addAttribute("greeting", "Welcome");

        List<Artists> list;
        if(keyword != null) {
            list = artistDao.getArtistData(keyword);
        }else {
            list = artistDao.getMusicData();
        }
        model.addAttribute("list", list);

        return "home";
    }



}
