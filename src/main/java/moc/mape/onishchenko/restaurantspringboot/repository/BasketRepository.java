package moc.mape.onishchenko.restaurantspringboot.repository;

import moc.mape.onishchenko.restaurantspringboot.entity.Basket;
import moc.mape.onishchenko.restaurantspringboot.entity.BasketId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BasketRepository extends JpaRepository<Basket, BasketId> {
}
