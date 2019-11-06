package moc.mape.onishchenko.restaurantspringboot.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "ingredients")
@IdClass(IngredientId.class)
public class Ingredient {

    @Id
    @Column(name = "id_product")
    private Long idProduct;

    @Id
    @Column(name = "id_dish")
    private Long idDish;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_product", insertable = false, updatable = false)
    private Product product;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_dish", insertable = false, updatable = false)
    private Dish dish;

    @Column(name = "weight")
    private Long weight;

    public Long getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Long idProduct) {
        this.idProduct = idProduct;
    }

    public Long getIdDish() {
        return idDish;
    }

    public void setIdDish(Long idDish) {
        this.idDish = idDish;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Dish getDish() {
        return dish;
    }

    public void setDish(Dish dish) {
        this.dish = dish;
    }

    public Long getWeight() {
        return weight;
    }

    public void setWeight(Long weight) {
        this.weight = weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ingredient that = (Ingredient) o;
        return Objects.equals(idProduct, that.idProduct) &&
                Objects.equals(idDish, that.idDish) &&
                Objects.equals(weight, that.weight);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idProduct, idDish, weight);
    }

    @Override
    public String toString() {
        return "Ingredient{" +
                "idProduct=" + idProduct +
                ", idDish=" + idDish +
                ", weight=" + weight +
                '}';
    }
}
