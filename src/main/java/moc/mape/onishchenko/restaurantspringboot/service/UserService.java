package moc.mape.onishchenko.restaurantspringboot.service;

import moc.mape.onishchenko.restaurantspringboot.entity.User;
import moc.mape.onishchenko.restaurantspringboot.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void create(String login, String password) {
        final User user = new User();
        user.setLogin(login);
        user.setPassword(password);

        userRepository.saveAndFlush(user);
    }

    public void printAll() {
        userRepository.findAll()
                .forEach(System.out::println);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }
}
