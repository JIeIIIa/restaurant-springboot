package moc.mape.onishchenko.restaurantspringboot.repository;

import moc.mape.onishchenko.restaurantspringboot.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
