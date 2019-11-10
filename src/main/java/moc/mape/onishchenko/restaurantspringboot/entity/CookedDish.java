package moc.mape.onishchenko.restaurantspringboot.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "cooked_dishes")
public class CookedDish {

    @Id
    @GeneratedValue(generator = "cookedDishIdSequence")
    @SequenceGenerator(
            schema = "public",
            name = "cookedDishIdSequence",
            sequenceName = "cooked_dishes_id_seq",
            allocationSize = 1)
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_dish")
    private Dish dish;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_order")
    private Order order;

    @Column(name = "is_ready")
    private boolean isReady;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Dish getDish() {
        return dish;
    }

    public void setDish(Dish dish) {
        this.dish = dish;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Boolean getReady() {
        return isReady;
    }

    public void setReady(Boolean ready) {
        isReady = ready;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CookedDish that = (CookedDish) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(dish, that.dish) &&
                Objects.equals(order, that.order) &&
                Objects.equals(isReady, that.isReady);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dish, order, isReady);
    }

    @Override
    public String toString() {
        return "CookedDish{" +
                "id=" + id +
                ", dish=" + dish +
                ", order=" + order +
                ", isReady=" + isReady +
                '}';
    }
}
