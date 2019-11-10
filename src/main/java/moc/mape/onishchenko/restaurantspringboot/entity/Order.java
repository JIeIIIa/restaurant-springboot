package moc.mape.onishchenko.restaurantspringboot.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(generator = "ordersIdSequence")
    @SequenceGenerator(
            schema = "public",
            name = "ordersIdSequence",
            sequenceName = "orders_id_seq",
            allocationSize = 1)
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user")
    private UserInfo user;

    @Column(name = "order_date")
    private LocalDateTime orderDate;

    @Column(name = "amount_payable")
    private Long amountPayable;

    @Column(name = "paid_date")
    private LocalDateTime paidDate;

    @Column(name = "paid")
    private Long paid;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private OrderStatus status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserInfo getUser() {
        return user;
    }

    public void setUser(UserInfo user) {
        this.user = user;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public Long getAmountPayable() {
        return amountPayable;
    }

    public void setAmountPayable(Long amountPayable) {
        this.amountPayable = amountPayable;
    }

    public LocalDateTime getPaidDate() {
        return paidDate;
    }

    public void setPaidDate(LocalDateTime paidDate) {
        this.paidDate = paidDate;
    }

    public Long getPaid() {
        return paid;
    }

    public void setPaid(Long paid) {
        this.paid = paid;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(id, order.id) &&
                Objects.equals(user, order.user) &&
                Objects.equals(orderDate, order.orderDate) &&
                Objects.equals(amountPayable, order.amountPayable) &&
                Objects.equals(paidDate, order.paidDate) &&
                Objects.equals(paid, order.paid) &&
                status == order.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user, orderDate, amountPayable, paidDate, paid, status);
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", user=" + user +
                ", orderDate=" + orderDate +
                ", amountPayable=" + amountPayable +
                ", paidDate=" + paidDate +
                ", paid=" + paid +
                ", status=" + status +
                '}';
    }
}
