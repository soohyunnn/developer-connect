package com.connect.developer.user.service.impl;

import com.connect.developer.user.domain.User;
import com.connect.developer.user.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public User saveUser(User user) {
        log.info("user 저장 - " + user);
        return userRepository.save(user);
    }
}
