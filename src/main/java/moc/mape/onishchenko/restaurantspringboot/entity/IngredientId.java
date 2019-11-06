package moc.mape.onishchenko.restaurantspringboot.entity;

import java.io.Serializable;
import java.util.Objects;

public class IngredientId implements Serializable {
    private Long idProduct;

    private Long idDish;

    public IngredientId() {
    }

    public IngredientId(Long idProduct, Long idDish) {
        this.idProduct = idProduct;
        this.idDish = idDish;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IngredientId that = (IngredientId) o;
        return Objects.equals(idProduct, that.idProduct) &&
                Objects.equals(idDish, that.idDish);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idProduct, idDish);
    }

    @Override
    public String toString() {
        return "IngredientId{" +
                "idProduct=" + idProduct +
                ", idDish=" + idDish +
                '}';
    }
}
