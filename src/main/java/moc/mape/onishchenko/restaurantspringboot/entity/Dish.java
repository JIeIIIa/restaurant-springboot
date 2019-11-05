package moc.mape.onishchenko.restaurantspringboot.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "dishes")
public class Dish implements Serializable {
    @Id
    @GeneratedValue(generator = "dishIdSequence")
    @SequenceGenerator(
            schema = "public",
            name = "dishIdSequence",
            sequenceName = "dishes_id_seq",
            allocationSize = 1)
    @Column(name="id")
    private Long id;

    @Column(name="title")
    private String title;

    @Column(name = "price")
    private Long price;

    @Column(name = "is_active")
    private Boolean isActive;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dish dish = (Dish) o;
        return Objects.equals(id, dish.id) &&
                Objects.equals(title, dish.title) &&
                Objects.equals(price, dish.price) &&
                Objects.equals(isActive, dish.isActive);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, price, isActive);
    }

    @Override
    public String toString() {
        return "Dish{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", isActive=" + isActive +
                '}';
    }
}
