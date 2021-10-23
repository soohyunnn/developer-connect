package com.connect.developer.user.service.impl;

import com.connect.developer.user.domain.Authority;
import com.connect.developer.user.domain.User;
import com.connect.developer.user.dto.UserDto;
import com.connect.developer.user.service.UserService;
import com.connect.developer.util.SecurityUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public User saveUser(User user) {
        log.info("user 저장 - " + user);
        return userRepository.save(user);
    }

    @Transactional
    @Override
    public User signup(UserDto userDto) {
        if (userRepository.findOneWithAuthoritiesByUserId(userDto.getUserId()).orElse(null) != null) {
            throw new RuntimeException("이미 가입되어 있는 유저입니다.");
        }

        Authority authority = Authority.builder()
                .authorityName("ROLE_USER")
                .build();

        User user = User.builder()
                .userId(userDto.getUserId())
                .password(passwordEncoder.encode(userDto.getPassword()))
                .nickname(userDto.getNickname())
                .name(userDto.getName())
                .email(userDto.getEmail())
                .imageId(userDto.getImageId())
                .build();

        return userRepository.save(user);
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<User> getUserWithAuthorities(String userId) {
        return userRepository.findOneWithAuthoritiesByUserId(userId);
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<User> getMyUserWithAuthorities() {
        return SecurityUtil.getCurrentUsername().flatMap(userRepository::findOneWithAuthoritiesByUserId);
    }
}
