package moc.mape.onishchenko.restaurantspringboot.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Api(tags = {"Welcome controller"})
@Controller
public class WelcomeController {

    @ApiOperation(value = "Gets start page ")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success|OK")
    })
    @GetMapping(value = {"", "/", "index"}, produces = MediaType.TEXT_HTML_VALUE)
    public String index() {
        return "index";
    }
}
