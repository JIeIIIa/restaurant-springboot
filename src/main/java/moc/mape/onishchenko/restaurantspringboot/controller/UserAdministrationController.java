package moc.mape.onishchenko.restaurantspringboot.controller;

import moc.mape.onishchenko.restaurantspringboot.dto.UserDto;
import moc.mape.onishchenko.restaurantspringboot.service.UserInfoService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class UserAdministrationController {

    private final UserInfoService userInfoService;

    public UserAdministrationController(UserInfoService userInfoService) {
        this.userInfoService = userInfoService;
    }

    @GetMapping(value = {"/admin/users"})
    public ModelAndView allUsers(ModelAndView modelAndView) {
        modelAndView.setViewName("administration/users/allUsers");
        modelAndView.addObject("users", userInfoService.findAll());

        return modelAndView;

    }

    @GetMapping(value = {"/admin/api/users/{id}"})
    public ResponseEntity<UserDto> userDetails(@PathVariable("id") Long id) {
        return ResponseEntity.ok(userInfoService.findById(id));
    }

    @GetMapping(value = {"/admin/users/{id}"})
    public ModelAndView userDetailsPage(ModelAndView modelAndView, @PathVariable("id") Long id) {
        modelAndView.setViewName("administration/users/userInfo");

        UserDto userDto = userInfoService.findById(id);
        modelAndView.addObject(userDto);

        return modelAndView;
    }

    @PutMapping(value = {"/admin/users/{id}"})
    public ModelAndView userDetails(@PathVariable("id") Long id,
                                    @ModelAttribute("userDto") UserDto userDto,
                                    ModelAndView modelAndView) {
        System.out.println(userDto);
        UserDto updated = userInfoService.update(userDto);
        modelAndView.setViewName("/administration/users/userInfo");
        modelAndView.addObject(updated);

        return modelAndView;
    }

    @DeleteMapping(value = {"/admin/users/{id}"})
    public RedirectView deleteUser(@PathVariable("id") Long id) {
        userInfoService.delete(id);

        System.out.println("deleting... " + id);
        return new RedirectView("/admin/users", true, true, false);
    }

}
