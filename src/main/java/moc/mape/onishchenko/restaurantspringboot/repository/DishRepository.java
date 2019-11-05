package moc.mape.onishchenko.restaurantspringboot.repository;

import moc.mape.onishchenko.restaurantspringboot.entity.Dish;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DishRepository extends JpaRepository<Dish, Long> {
}
