package moc.mape.onishchenko.restaurantspringboot.controller;

import moc.mape.onishchenko.restaurantspringboot.entity.User;
import moc.mape.onishchenko.restaurantspringboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/")
    public ModelAndView allUsers() {
        final ModelAndView mav = new ModelAndView("users");
        final List<User> users = userService.findAll();
        mav.addObject("allUsers", users);

        return mav;
    }
}
