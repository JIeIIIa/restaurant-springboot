package moc.mape.onishchenko.restaurantspringboot.controller;

import moc.mape.onishchenko.restaurantspringboot.dto.UserDto;
import moc.mape.onishchenko.restaurantspringboot.service.UserInfoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

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

    @GetMapping(value = {"/admin/users/{id}"})
    public ResponseEntity<UserDto> userDetails(@PathVariable("id") Long id) {
        return ResponseEntity.ok(userInfoService.findById(id));
    }

    @DeleteMapping(value = {"/admin/users/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public void deleteUser(@PathVariable("id") Long id) {
//        userInfoService.delete(id);
        System.out.println("deleting... " + id);
    }

}
