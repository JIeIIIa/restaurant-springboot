package moc.mape.onishchenko.restaurantspringboot.controller;

import moc.mape.onishchenko.restaurantspringboot.dto.UserDto;
import moc.mape.onishchenko.restaurantspringboot.entity.UserRole;
import moc.mape.onishchenko.restaurantspringboot.service.UserInfoService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;

import static java.util.Collections.singletonList;


@Controller
public class RegistrationController {
    static final String NEW_USER_ATTRIBUTE_NAME = "userDto";

    private final UserInfoService userInfoService;

    @Value("${debug:false}")
    private boolean debug;

    public RegistrationController(UserInfoService userInfoService) {
        this.userInfoService = userInfoService;
    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public ModelAndView registrationPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("registration");

        UserDto user = new UserDto();
        modelAndView.addObject(NEW_USER_ATTRIBUTE_NAME, user);
        return modelAndView;
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public ModelAndView registrationNewUser(@ModelAttribute(NEW_USER_ATTRIBUTE_NAME) UserDto userDto,
                                            ModelAndView modelAndView,
                                            HttpServletRequest request) {
        if (false) {
            modelAndView.setViewName("registration");
            userDto.setPassword("");
            userDto.setPasswordConfirmation("");
            modelAndView.addObject(NEW_USER_ATTRIBUTE_NAME, userDto);

            return modelAndView;
        }

        userInfoService.register(userDto);

        UriComponents uriComponents = UriComponentsBuilder.newInstance()
                .path("/user/{login}/")
                .build()
                .expand(userDto.getLogin())
                .encode();
        modelAndView.setView(new RedirectView(uriComponents.toUriString(), true, true, false));

        autoLogin(userDto.getLogin(), request);

        return modelAndView;
    }

    private void autoLogin(String login, HttpServletRequest request) {
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(login, null,
                singletonList(new SimpleGrantedAuthority(UserRole.CLIENT.toString())));
        SecurityContextHolder.getContext().setAuthentication(token);
        request.getSession().setAttribute(HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY, SecurityContextHolder.getContext());
    }
}
