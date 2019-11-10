package moc.mape.onishchenko.restaurantspringboot.repository;

import moc.mape.onishchenko.restaurantspringboot.entity.CookedDish;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CookedDishRepository extends JpaRepository<CookedDish, Long> {
}
