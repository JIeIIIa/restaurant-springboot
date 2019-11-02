package moc.mape.onishchenko.restaurantspringboot.entity;

public enum Role {
    USER, ADMIN;


    @Override
    public String toString() {
        return name() + "_ROLE";
    }
}
