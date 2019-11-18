package moc.mape.onishchenko.restaurantspringboot.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import moc.mape.onishchenko.restaurantspringboot.util.WebPageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.RequestDispatcher;
import java.util.Map;
import java.util.Optional;

@Api(tags = {"Errors"})
@Controller
public class CommonErrorController implements ErrorController {
    private static final String ERROR_PATH = "error";

    @Value("${include-stack-trace:false}")
    private boolean includeStackTrace;

    private final ErrorAttributes errorAttributes;

    @Autowired
    public CommonErrorController(ErrorAttributes errorAttributes) {
        this.errorAttributes = errorAttributes;
    }

    @ApiOperation(value = "General error page")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "if error was occurred"),
    })
    @GetMapping(value = ERROR_PATH, produces = MediaType.TEXT_HTML_VALUE)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ModelAndView error(@ApiIgnore WebRequest request,
                       @ApiIgnore ModelAndView modelAndView) {

        Map<String, Object> errorAttributes = getErrorAttributes(request, includeStackTrace);

        modelAndView.addAllObjects(errorAttributes);
        String url = Optional.ofNullable(
                (String) (request.getAttribute(RequestDispatcher.ERROR_REQUEST_URI, 0)))
                .orElse("");
        modelAndView.addObject("url", url);
        modelAndView.setViewName("errors/commonError");
        return modelAndView;
    }

    @Override
    public String getErrorPath() {
        return ERROR_PATH;
    }

    private Map<String, Object> getErrorAttributes(WebRequest request, boolean includeStackTrace) {
        return errorAttributes.getErrorAttributes(request, includeStackTrace);
    }

    @ApiOperation(value = "Page not found")
    @ApiResponses(value = {
            @ApiResponse(code = 404, message = "if page not found"),
    })
    @RequestMapping(value = "/page-not-found",
            method = {RequestMethod.GET, RequestMethod.POST},
            produces = MediaType.TEXT_HTML_VALUE)
    public ModelAndView pageNotFound(@RequestParam(name = "url", required = false) String url) {

        return WebPageUtils.customPageNotFound(url);
    }

    @ApiOperation(value = "Access denied page")
    @ApiResponses(value = {
            @ApiResponse(code = 403, message = "if access to the page is prohibited"),
    })
    @RequestMapping(value = "/access-denied",
            method = {RequestMethod.GET, RequestMethod.POST},
            produces = MediaType.TEXT_HTML_VALUE)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public String accessDenied() {
        return "errors/accessDenied";
    }
}
