package moc.mape.onishchenko.restaurantspringboot.dto;

import com.fasterxml.jackson.annotation.JsonView;
import moc.mape.onishchenko.restaurantspringboot.entity.UserRole;
import moc.mape.onishchenko.restaurantspringboot.transfer.AdminEditing;
import moc.mape.onishchenko.restaurantspringboot.transfer.ChangePassword;
import moc.mape.onishchenko.restaurantspringboot.transfer.Exist;
import moc.mape.onishchenko.restaurantspringboot.transfer.New;
import moc.mape.onishchenko.restaurantspringboot.validator.ConfirmedPassword;
import moc.mape.onishchenko.restaurantspringboot.validator.EqualPasswords;
import moc.mape.onishchenko.restaurantspringboot.validator.UniqueLogin;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@EqualPasswords(
        groups = {New.class, ChangePassword.class}, message = "{EqualPasswords}")
public class UserDto implements ConfirmedPassword {
    @JsonView(value = {Exist.class})
    private Long id;

    @NotNull(message = "{NotNull.login}", groups = {New.class, Exist.class})
    @Size(min = 4, max = 30, message = "{Size.login}",
            groups = {New.class, Exist.class})
    @Pattern(regexp = "[\\d\\p{L}.]+", message = "Pattern.login",
            groups = {New.class, Exist.class})
    @UniqueLogin(groups = New.class)
    @JsonView(value = {AdminEditing.class})
    private String login;

    @NotNull(message = "{NotNull.oldPassword}", groups = {ChangePassword.class})
    @Size(min = 6, max = 65, message = "{Size.password}",
            groups = {ChangePassword.class})
    @JsonView(value = {ChangePassword.class})
    private String oldPassword;

    @NotNull(message = "{NotNull.password}", groups = {New.class, ChangePassword.class})
    @Size(min = 6, max = 65, message = "{Size.password}",
            groups = {New.class, ChangePassword.class})
    @JsonView(value = {ChangePassword.class})
    private String password;

    @JsonView(value = {ChangePassword.class})
    private String passwordConfirmation;

    @NotNull(message = "{NotNull.role}", groups = {AdminEditing.class})
    @JsonView(value = {AdminEditing.class})
    private UserRole role;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
                ", login='" + login + '\'' +
                ", role=" + role +
                '}';
    }
}
