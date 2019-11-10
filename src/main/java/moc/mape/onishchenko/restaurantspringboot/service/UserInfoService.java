package moc.mape.onishchenko.restaurantspringboot.service;

import moc.mape.onishchenko.restaurantspringboot.dto.UserDto;
import moc.mape.onishchenko.restaurantspringboot.entity.UserInfo;
import moc.mape.onishchenko.restaurantspringboot.entity.UserRole;
import moc.mape.onishchenko.restaurantspringboot.repository.UserInfoRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class UserInfoService {
    private final UserInfoRepository userInfoRepository;

    private final PasswordEncoder passwordEncoder;

    public UserInfoService(UserInfoRepository userInfoRepository, PasswordEncoder passwordEncoder) {
        this.userInfoRepository = userInfoRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void register(final UserDto newUser) {
        final UserInfo userInfo = new UserInfo();
        userInfo.setLoginUser(newUser.getLogin());
        final String encodedPassword = passwordEncoder.encode(newUser.getPassword());
        userInfo.setPasswordUser(encodedPassword);
        userInfo.setRole(UserRole.CLIENT);

        userInfoRepository.saveAndFlush(userInfo);
    }
}
