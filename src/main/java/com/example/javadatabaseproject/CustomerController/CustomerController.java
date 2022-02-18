package com.example.javadatabaseproject.CustomerController;
import com.example.javadatabaseproject.Models.Customer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class CustomerController {

    //@Value("${welcome.message}")
    //private String message = "wallanboy";

    private List<Customer> tasks;

    //@GetMapping("/home" )
    //@RequestMapping(value = "/", method = RequestMethod.GET)
    @RequestMapping(value = "/home")
    public String home(Model model){
        model.addAttribute("greeting", "Welcome buskin");
        return "home";
    }
    /*@GetMapping("/")
    public String main(Model model) {
        model.addAttribute("message", message);
        model.addAttribute("tasks", tasks);

        return "welcome"; //view
    }

    // /hello?name=kotlin
    @GetMapping("/hello")
    public String mainWithParam(@RequestParam(name = "name", required = false, defaultValue = "")
                    String name, Model model) {

        model.addAttribute("message", name);

        return "welcome"; //view
    }*/
}
