package com.neobis.springbootdemo.sevice;

import com.neobis.springbootdemo.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface CustomUserDetailsService extends UserDetailsService {
    void saveUser(User user);

    public User findByUserName(String userName);
}
