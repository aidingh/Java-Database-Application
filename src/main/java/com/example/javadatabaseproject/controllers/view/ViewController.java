package com.example.javadatabaseproject.controllers.view;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ViewController {

      @RequestMapping(value = "/home")
    public String home(Model model){
        model.addAttribute("name", "Rickard");
        return "home";
    }
}
