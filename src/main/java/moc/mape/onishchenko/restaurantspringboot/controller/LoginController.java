package moc.mape.onishchenko.restaurantspringboot.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpSession;
import java.util.Locale;
import java.util.Objects;

@Controller
public class LoginController {
    private static final String SPRING_SECURITY_LAST_EXCEPTION = "SPRING_SECURITY_LAST_EXCEPTION";
    private static final String SECURITY_LAST_EXCEPTION_MESSAGE_MODEL_ATTRIBUTE = "securityLastExceptionMessage";

    @RequestMapping("/login")
    public ModelAndView login(HttpSession session,
                              Locale locale) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");

        Object securityLastException = session.getAttribute(SPRING_SECURITY_LAST_EXCEPTION);
        if (Objects.nonNull(securityLastException)) {
            String message = "auth with error";
            modelAndView.addObject(SECURITY_LAST_EXCEPTION_MESSAGE_MODEL_ATTRIBUTE, message);
            session.removeAttribute(SPRING_SECURITY_LAST_EXCEPTION);
        }
        return modelAndView;
    }

    @RequestMapping("/authorized")
    public ModelAndView authorized(Authentication authentication) {
        String login = authentication.getName();
        UriComponents uriComponents = UriComponentsBuilder.newInstance()
                .path("/user/{login}/")
                .build()
                .expand(login)
                .encode();

        ModelAndView modelAndView = new ModelAndView(new RedirectView(uriComponents.toUriString(), true, true, false));

        return modelAndView;
    }
}
