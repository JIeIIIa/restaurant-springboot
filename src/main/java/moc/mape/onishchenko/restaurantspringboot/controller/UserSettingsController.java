package moc.mape.onishchenko.restaurantspringboot.controller;

import moc.mape.onishchenko.restaurantspringboot.dto.UserDto;
import moc.mape.onishchenko.restaurantspringboot.service.BindingErrorResolver;
import moc.mape.onishchenko.restaurantspringboot.service.UserInfoService;
import moc.mape.onishchenko.restaurantspringboot.transfer.ChangeAvatar;
import moc.mape.onishchenko.restaurantspringboot.transfer.ChangePassword;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserSettingsController {

    private static final Logger LOG = LogManager.getLogger(UserSettingsController.class);

    private BindingErrorResolver bindingErrorResolver;

    private UserInfoService userInfoService;

    @Autowired
    public UserSettingsController(BindingErrorResolver bindingErrorResolver,
                                  UserInfoService userInfoService) {
        this.bindingErrorResolver = bindingErrorResolver;
        this.userInfoService = userInfoService;
    }

    @GetMapping("/user/{login}/settings")
    public String allSettings(@PathVariable("login") String login) {
        LOG.traceEntry("Settings for user = '{}'", login);

        return "settings/settings";
    }

    @GetMapping(value = "/user/{login}/settings/password")
    public ModelAndView password(@PathVariable("login") String login,
                                       ModelAndView modelAndView) {
        modelAndView.setViewName("settings/settings");
        modelAndView.addObject("activeItem", "password");
        modelAndView.addObject(new UserDto());

        return modelAndView;
    }

    @PutMapping(value = "/user/{login}/settings/password")
    public ModelAndView changePassword(@PathVariable("login") String login,
                                       @Validated(ChangePassword.class) @ModelAttribute UserDto userDto,
                                       BindingResult bindingResult,
                                       ModelAndView modelAndView) {
        userDto.setLogin(login);

        modelAndView.setViewName("settings/settings");
        modelAndView.addObject("activeItem", "password");
        modelAndView.addObject("msgResult", bindingErrorResolver.resolveMessage("user.password.change.error"));
        modelAndView.addObject("msgResultType", "error");

        if (bindingResult.hasErrors()) {
            modelAndView.addObject(userDto);

            return modelAndView;
        }

        if (userInfoService.setNewPassword(userDto)) {
            modelAndView.addObject("msgResult", bindingErrorResolver.resolveMessage("user.password.change.success"));
            modelAndView.addObject("msgResultType", "info");
        }
        modelAndView.addObject(new UserDto());
        return modelAndView;
    }

    @GetMapping(value = "/user/{login}/settings/avatar")
    public ModelAndView avatar(@PathVariable("login") String login,
                                 ModelAndView modelAndView) {
        modelAndView.setViewName("settings/settings");
        modelAndView.addObject("activeItem", "avatar");

        return modelAndView;
    }

    @PostMapping(value = "/user/{login}/settings/avatar", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ModelAndView updateAvatar(@PathVariable("login") String login,
                                     @Validated(ChangeAvatar.class) @ModelAttribute UserDto userDto,
                                     ModelAndView modelAndView) {
        userDto.setLogin(login);

//        if (userInfoService.updateAvatar(userDto)) {
//            return ResponseEntity
//                    .status(HttpStatus.OK)
//                    .headers(textHeader())
//                    .body(bindingErrorResolver.resolveMessage("user.avatar.change.success", locale));
//        } else {
//            return ResponseEntity
//                    .status(HttpStatus.UNPROCESSABLE_ENTITY)
//                    .headers(textHeader())
//                    .body(bindingErrorResolver.resolveMessage("user.avatar.change.error", locale));
//        }

        return modelAndView;
    }

    @DeleteMapping(value = "/user/{login}/settings/avatar")
    public ModelAndView removeAvatar(@PathVariable("login") String login,
                                     ModelAndView modelAndView) {
//        if(userInfoService.deleteAvatar(login)) {
//            return ResponseEntity
//                    .status(HttpStatus.OK)
//                    .headers(jsonHeader())
//                    .body(bindingErrorResolver.resolveMessage("user.avatar.remove.success"));
//        } else {
//            return ResponseEntity
//                    .status(HttpStatus.UNPROCESSABLE_ENTITY)
//                    .headers(jsonHeader())
//                    .body(bindingErrorResolver.resolveMessage("user.avatar.change.error"));
//        }

        return modelAndView;
    }
}
