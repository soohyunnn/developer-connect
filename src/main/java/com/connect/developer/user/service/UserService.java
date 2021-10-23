package com.connect.developer.user.service;

import com.connect.developer.user.domain.User;
import com.connect.developer.user.dto.UserDto;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface UserService {

    public User saveUser(User user);

    public User signup(UserDto userDto);

    public Optional<User> getUserWithAuthorities(String userId);

    public Optional<User> getMyUserWithAuthorities();

}
