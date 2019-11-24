package moc.mape.onishchenko.restaurantspringboot.entity;

import org.hibernate.annotations.Type;
import org.springframework.lang.Nullable;

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

    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private UserRole role;

    @Lob
    @Type(type = "org.hibernate.type.ImageType")
    @Nullable
    @Basic(fetch = FetchType.LAZY)
    @Column(length = 1_048_576)         /*max length == 1Mb*/
    private byte[] avatar;

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

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    public byte[] getAvatar() {
        return avatar;
    }

    public void setAvatar(byte[] avatar) {
        this.avatar = avatar;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserInfo userInfo = (UserInfo) o;
        return Objects.equals(id, userInfo.id) &&
                Objects.equals(loginUser, userInfo.loginUser) &&
                Objects.equals(passwordUser, userInfo.passwordUser) &&
                role == userInfo.role;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, loginUser, passwordUser, role);
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
