package moc.mape.onishchenko.restaurantspringboot.controller;

import io.swagger.annotations.*;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Api(tags = {"Welcome controller"})
@Controller
public class UserController {

    @ApiOperation(value = "Gets start page ")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success|OK"),
            @ApiResponse(code = 302, message = "Redirect to /login if user is not authorized")
    })
    @GetMapping(value = {"/user/{login}"}, produces = MediaType.TEXT_HTML_VALUE)
    public ModelAndView homePage(@ApiParam(value = "user login", required = true) @PathVariable("login") String login,
                           ModelAndView modelAndView) {
        modelAndView.setViewName("home");

        return modelAndView;
    }

}
