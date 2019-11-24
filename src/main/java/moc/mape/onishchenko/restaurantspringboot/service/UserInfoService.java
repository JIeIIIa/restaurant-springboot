package moc.mape.onishchenko.restaurantspringboot.service;

import moc.mape.onishchenko.restaurantspringboot.dto.UserDto;
import moc.mape.onishchenko.restaurantspringboot.entity.UserInfo;
import moc.mape.onishchenko.restaurantspringboot.entity.UserRole;
import moc.mape.onishchenko.restaurantspringboot.repository.UserInfoRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

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

    public List<UserDto> findAll() {
        return userInfoRepository.findAllByOrderByLoginUserAsc()
                .stream()
                .map(this::toUserDto)
                .collect(toList());
    }

    private UserDto toUserDto(UserInfo userInfo) {
        if (userInfo == null) {
            return null;
        }
        final UserDto userDto = new UserDto();
        userDto.setId(userInfo.getId());
        userDto.setLogin(userInfo.getLoginUser());
        userDto.setRole(userInfo.getRole());

        return userDto;
    }

    public UserDto findById(Long id) {
        return userInfoRepository.findById(id)
                .map(this::toUserDto)
                .orElseThrow(IllegalArgumentException::new);
    }

    public void delete(Long id) {
        final UserInfo user = userInfoRepository.findById(id).orElseThrow(IllegalArgumentException::new);
        userInfoRepository.removeById(user.getId());
    }

    public UserDto update(UserDto userDto) {
        UserInfo user = userInfoRepository.findById(userDto.getId())
                .orElseThrow(IllegalArgumentException::new);
        updateUserInfo(user, userDto);

        UserInfo saved = userInfoRepository.saveAndFlush(user);

        return toUserDto(saved);
    }

    private void updateUserInfo(UserInfo userInfo, UserDto userDto) {
        if (userInfo == null || userDto == null) {
            throw new IllegalArgumentException();
        }
        userInfo.setId(userDto.getId());
        userInfo.setLoginUser(userDto.getLogin());
        userInfo.setRole(userDto.getRole());
    }

    public boolean existsByLogin(String login) {
        Optional<UserInfo> user = userInfoRepository.findByLoginUser(login);

        return user.isPresent();
    }
}
