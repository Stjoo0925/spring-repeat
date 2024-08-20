package com.test.springrepeat.user.service;


import com.test.springrepeat.user.entity.UserEntity;

import com.test.springrepeat.user.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;


@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    //전체조회
    @Transactional
    public List<UserEntity> findAllUser() {
        return userRepository.findAll();
    }

    //상세조회
    @Transactional
    public Optional<UserEntity> findUserById(Integer id) {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("ID는 0보다 커야 합니다.");
        }
        return userRepository.findById(id);
    }
}

