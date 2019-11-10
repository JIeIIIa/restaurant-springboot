package moc.mape.onishchenko.restaurantspringboot.entity;

import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "users_info")
public class UserInfo {
    @Id
    @GeneratedValue(generator = "userInfoIdSequence")
    @SequenceGenerator(
            schema = "public",
            name = "userInfoIdSequence",
            sequenceName = "users_info_id_seq",
            allocationSize = 1)
    @Column(name = "id")
    private Long id;

    @Column(name = "login_user")
    private String loginUser;

    @Column(name = "password_user")
    private String passwordUser;

    @Column(name = "salt")
    private String salt;

    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private UserRole role;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLoginUser() {
        return loginUser;
    }

    public void setLoginUser(String loginUser) {
        this.loginUser = loginUser;
    }

    public String getPasswordUser() {
        return passwordUser;
    }

    public void setPasswordUser(String passwordUser) {
        this.passwordUser = passwordUser;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserInfo userInfo = (UserInfo) o;
        return Objects.equals(id, userInfo.id) &&
                Objects.equals(loginUser, userInfo.loginUser) &&
                Objects.equals(passwordUser, userInfo.passwordUser) &&
                Objects.equals(salt, userInfo.salt) &&
                role == userInfo.role;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, loginUser, passwordUser, salt, role);
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "id=" + id +
                ", loginUser='" + loginUser + '\'' +
                ", role=" + role +
                '}';
    }
}