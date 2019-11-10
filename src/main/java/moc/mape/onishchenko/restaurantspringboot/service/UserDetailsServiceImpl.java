package moc.mape.onishchenko.restaurantspringboot.service;

import moc.mape.onishchenko.restaurantspringboot.entity.UserInfo;
import moc.mape.onishchenko.restaurantspringboot.repository.UserInfoRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UserInfoRepository userInfoRepository;

    public UserDetailsServiceImpl(UserInfoRepository userInfoRepository) {
        this.userInfoRepository = userInfoRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        final UserDetails userDetails = userInfoRepository.findByLoginUser(login)
                .map(this::convert)
                .orElseThrow(() -> new UsernameNotFoundException(login + " not found"));

        return userDetails;
    }

    private <U> UserDetails convert(UserInfo userInfo) {
        return User.withUsername(userInfo.getLoginUser())
                .password(userInfo.getPasswordUser())
                .roles(userInfo.getRole().name())
                .disabled(false)
                .build();
    }
}
