package com.example.javadatabaseproject.controllers.rest;


import com.example.javadatabaseproject.access.layer.ArtistDao;
import com.example.javadatabaseproject.models.Artists;
import com.example.javadatabaseproject.models.CustomerGenre;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@Controller
public class ArtistsController {

    private final ArtistDao artistDao;

    public ArtistsController(ArtistDao artistDao) {
        this.artistDao = artistDao;
    }

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String home(Artists artists, Model model, String keyword) {
        model.addAttribute("greeting", "Welcome");
        //model.addAttribute("artists", artistDao.getArtistData());
        System.out.println(keyword);
        if(keyword!=null) {
            //List<Artists> list = artistDao.getArtistData();
            //model.addAttribute("list", list);
        }else {
            //List<Shop> list = service.getAllShops();
            //model.addAttribute("list", list);
           List<Artists> list = artistDao.getArtistData();
           model.addAttribute("list", list);
        }
        return "home";
    }

   /* @RequestMapping(value = "/api/customers/popular/genre/{id}", method = RequestMethod.GET)
    public List<CustomerGenre> getPopularGenre(Model model, @PathVariable int id){
        return customerDao.getPopularGenre(id);
        model.addAttribute("popularGenre", customerDao.getPopularGenre(id));
        return "CustomerPopularGenre";
    }*/

}
