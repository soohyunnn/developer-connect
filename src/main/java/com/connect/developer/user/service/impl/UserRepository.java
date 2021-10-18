package com.connect.developer.user.service.impl;

import com.connect.developer.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}