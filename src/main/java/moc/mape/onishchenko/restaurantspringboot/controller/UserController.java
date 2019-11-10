package moc.mape.onishchenko.restaurantspringboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {

    @GetMapping(value = {"/user/{login}"})
    @ResponseBody
    public String homePage(@PathVariable("login") String login) {
        return "Hello, " + login;
    }

}
