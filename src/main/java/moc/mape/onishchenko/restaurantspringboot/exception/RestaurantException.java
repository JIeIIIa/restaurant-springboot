package moc.mape.onishchenko.restaurantspringboot.exception;

import lombok.Getter;

@Getter
public class RestaurantException extends RuntimeException {
    private String messageKey;

    public RestaurantException(String messageKey) {
        super();
        this.messageKey = messageKey;
    }
}
