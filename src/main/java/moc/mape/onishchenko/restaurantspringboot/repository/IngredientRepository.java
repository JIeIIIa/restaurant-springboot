package moc.mape.onishchenko.restaurantspringboot.repository;

import moc.mape.onishchenko.restaurantspringboot.entity.Ingredient;
import moc.mape.onishchenko.restaurantspringboot.entity.IngredientId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IngredientRepository extends JpaRepository<Ingredient, IngredientId> {
    List<Ingredient> findByIdProduct(Long idProduct);

    List<Ingredient> findByIdDish(Long idDish);
}
