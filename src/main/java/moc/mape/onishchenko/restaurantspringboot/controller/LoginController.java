package moc.mape.onishchenko.restaurantspringboot.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpSession;
import java.util.Locale;
import java.util.Objects;

@Api(tags = {"Auth controller"})
@Controller
public class LoginController {
    private static final String SPRING_SECURITY_LAST_EXCEPTION = "SPRING_SECURITY_LAST_EXCEPTION";
    private static final String SECURITY_LAST_EXCEPTION_MESSAGE_MODEL_ATTRIBUTE = "securityLastExceptionMessage";

    @ApiOperation(value = "Gets start page ")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success|OK")
    })
    @GetMapping(value = "/login",
            produces = MediaType.TEXT_HTML_VALUE)
    public ModelAndView login(@ApiIgnore HttpSession session,
                              @ApiIgnore Locale locale) {
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

    @ApiOperation(value = "Gets start page ")
    @ApiResponses(value = {
            @ApiResponse(code = 302, message = "Redirect to user home page if authorization was success. Otherwise, redirect to Login page.")
    })
    @GetMapping(value = "/authorized",
            produces = MediaType.TEXT_HTML_VALUE)
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
