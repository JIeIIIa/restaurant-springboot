package moc.mape.onishchenko.restaurantspringboot.repository;

import moc.mape.onishchenko.restaurantspringboot.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UserInfoRepository extends JpaRepository<UserInfo, Long> {

    List<UserInfo> findAllByOrderByLoginUserAsc();

    Optional<UserInfo> findByLoginUser(@Param("loginUser") String login);

    @Modifying
    @Query(value = "delete from UserInfo u where u.id = :id")
    void removeById(@Param("id") Long id);
}
