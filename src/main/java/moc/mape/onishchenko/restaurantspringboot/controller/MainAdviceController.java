package moc.mape.onishchenko.restaurantspringboot.controller;

import io.swagger.annotations.Api;
import moc.mape.onishchenko.restaurantspringboot.util.WebPageUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;

@Api(tags = {"Errors"})
@ControllerAdvice
public class MainAdviceController {

    @ExceptionHandler(NoHandlerFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ModelAndView pageNotFound(HttpServletRequest request) {

        return WebPageUtils.customPageNotFound(request.getRequestURL().toString());
    }
}
