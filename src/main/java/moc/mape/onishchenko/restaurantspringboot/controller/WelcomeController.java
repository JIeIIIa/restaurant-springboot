package moc.mape.onishchenko.restaurantspringboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WelcomeController {
    @GetMapping(value = {"", "/", "index"})
    public String index() {
        return "index";
    }
}
