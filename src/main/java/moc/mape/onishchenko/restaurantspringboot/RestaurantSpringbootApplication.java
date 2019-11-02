package moc.mape.onishchenko.restaurantspringboot;

import moc.mape.onishchenko.restaurantspringboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RestaurantSpringbootApplication implements CommandLineRunner {
    @Autowired
    private UserService userService;

    public static void main(String[] args) {
        SpringApplication.run(RestaurantSpringbootApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        userService.create("Admin", "password");
        userService.create("User", "p@sswOrd");
        userService.printAll();
    }
}
