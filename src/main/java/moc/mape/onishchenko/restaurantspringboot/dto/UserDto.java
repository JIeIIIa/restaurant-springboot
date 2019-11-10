package moc.mape.onishchenko.restaurantspringboot.dto;

import moc.mape.onishchenko.restaurantspringboot.entity.UserRole;

public class UserDto {
    private Long id;

    private String Login;

    private String Password;

    private String passwordConfirmation;

    private UserRole role;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return Login;
    }

    public void setLogin(String login) {
        Login = login;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getPasswordConfirmation() {
        return passwordConfirmation;
    }

    public void setPasswordConfirmation(String passwordConfirmation) {
        this.passwordConfirmation = passwordConfirmation;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "id=" + id +
                ", Login='" + Login + '\'' +
                ", role=" + role +
                '}';
    }
}
