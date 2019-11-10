package moc.mape.onishchenko.restaurantspringboot.entity;

import java.io.Serializable;
import java.util.Objects;

public class BasketId implements Serializable {
    private Long idUser;

    private Long idDish;

    public BasketId() {
    }

    public BasketId(Long idUser, Long idDish) {
        this.idUser = idUser;
        this.idDish = idDish;
    }

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
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
        BasketId that = (BasketId) o;
        return Objects.equals(idUser, that.idUser) &&
                Objects.equals(idDish, that.idDish);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idUser, idDish);
    }

    @Override
    public String toString() {
        return "IngredientId{" +
                "idUser=" + idUser +
                ", idDish=" + idDish +
                '}';
    }
}
