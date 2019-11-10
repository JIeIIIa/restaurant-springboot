package moc.mape.onishchenko.restaurantspringboot.util;

import org.springframework.web.servlet.ModelAndView;

public class WebPageUtils {
    private WebPageUtils() {

    }

    public static ModelAndView customPageNotFound(String url) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("url", url);
        modelAndView.setViewName("errors/pageNotFound");

        return modelAndView;
    }
}
