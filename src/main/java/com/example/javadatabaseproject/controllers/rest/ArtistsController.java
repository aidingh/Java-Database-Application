package com.example.javadatabaseproject.controllers.rest;


import com.example.javadatabaseproject.access.layer.ArtistDao;
import com.example.javadatabaseproject.models.Artists;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author Aidin Ghassemloi och Richard Cruz.
 * Controller class for searhing tracks and display its result as an HTML-page.
 */
@Controller
public class ArtistsController {

    private final ArtistDao artistDao;

    public ArtistsController(ArtistDao artistDao) {
        this.artistDao = artistDao;
    }

    /**
     * Function will display random songs if client have not made a search.
     * But if there is a search and the track is found, then it will be displayed for the client.
     *
     * @param  model add a model attribute to the HTML-page
     * @param  keyword search string containing the track searched by the client.
     */
    @RequestMapping(path = {"/home","/search"})
    public String home(Model model, String keyword) {

        model.addAttribute("greeting", "Welcome");

        List<Artists> list;
        if(keyword != null) {
            list = artistDao.getArtistData(keyword);
        }else{
            list = artistDao.getMusicData();
        }

        model.addAttribute("list", list);
        return "home";
    }
}
