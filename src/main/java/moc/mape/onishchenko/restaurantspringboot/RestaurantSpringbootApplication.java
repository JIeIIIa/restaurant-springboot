package moc.mape.onishchenko.restaurantspringboot;

import moc.mape.onishchenko.restaurantspringboot.entity.Dish;
import moc.mape.onishchenko.restaurantspringboot.entity.Ingredient;
import moc.mape.onishchenko.restaurantspringboot.entity.Product;
import moc.mape.onishchenko.restaurantspringboot.repository.DishRepository;
import moc.mape.onishchenko.restaurantspringboot.repository.IngredientRepository;
import moc.mape.onishchenko.restaurantspringboot.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.transaction.Transactional;

@SpringBootApplication
public class RestaurantSpringbootApplication implements CommandLineRunner {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private DishRepository dishRepository;
    @Autowired
    private IngredientRepository ingredientRepository;

    public static void main(String[] args) {
        SpringApplication.run(RestaurantSpringbootApplication.class, args);
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        final Dish dish = new Dish();
        dish.setPrice(123L);
        dish.setTitle("qwerty");
        dish.setActive(true);

        dishRepository.saveAndFlush(dish);

        final Product product = new Product();
        product.setTitle("my_product");
        productRepository.saveAndFlush(product);

        final Ingredient ingredient = new Ingredient();
//        ingredient.setDish(dish);
//        ingredient.setProduct(product);
        ingredient.setIdDish(dish.getId());
        ingredient.setIdProduct(product.getId());
        ingredient.setWeight(777L);
        ingredientRepository.save(ingredient);
//        final IngredientId ingredientId = new IngredientId();
//        ingredientId.setIdDish(9L);
//        ingredientId.setIdProduct(9L);
//        ingredientRepository.findById(ingredientId).ifPresent(System.out::println);
    }
}
