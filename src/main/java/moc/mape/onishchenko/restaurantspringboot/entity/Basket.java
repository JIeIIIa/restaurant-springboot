package moc.mape.onishchenko.restaurantspringboot.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "baskets")
@IdClass(BasketId.class)
public class Basket {

    @Id
    @Column(name = "id_user")
    private Long idUser;

    @Id
    @Column(name = "id_dish")
    private Long idDish;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user", insertable = false, updatable = false)
    private UserInfo user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_dish", insertable = false, updatable = false)
    private Dish dish;

    @Column(name = "amount")
    private Long amount;

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

    public UserInfo getUser() {
        return user;
    }

    public void setUser(UserInfo user) {
        this.user = user;
    }

    public Dish getDish() {
        return dish;
    }

    public void setDish(Dish dish) {
        this.dish = dish;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Basket that = (Basket) o;
        return Objects.equals(idUser, that.idUser) &&
                Objects.equals(idDish, that.idDish) &&
                Objects.equals(amount, that.amount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idUser, idDish, amount);
    }

    @Override
    public String toString() {
        return "Ingredient{" +
                "idUser=" + idUser +
                ", idDish=" + idDish +
                ", amount=" + amount +
                '}';
    }
}
