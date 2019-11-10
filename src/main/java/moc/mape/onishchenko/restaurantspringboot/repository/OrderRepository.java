package moc.mape.onishchenko.restaurantspringboot.repository;

import moc.mape.onishchenko.restaurantspringboot.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
