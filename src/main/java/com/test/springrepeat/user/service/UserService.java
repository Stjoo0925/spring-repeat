package com.test.springrepeat.user.service;

import com.test.springrepeat.user.entity.UserEntity;
import com.test.springrepeat.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserEntity> findAllUser() {
        return userRepository.findAll();
    }
}
