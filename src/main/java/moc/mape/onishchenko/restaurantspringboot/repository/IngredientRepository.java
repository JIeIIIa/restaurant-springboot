package moc.mape.onishchenko.restaurantspringboot.repository;

import moc.mape.onishchenko.restaurantspringboot.entity.Ingredient;
import moc.mape.onishchenko.restaurantspringboot.entity.IngredientId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredientRepository extends JpaRepository<Ingredient, IngredientId> {
}
