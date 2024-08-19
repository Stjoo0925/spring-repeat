package com.test.springrepeat.user.service;

import com.test.springrepeat.user.entity.UserEntity;
import com.test.springrepeat.user.repository.UserRepository;
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

    public List<UserEntity> findAllUser() {
        return userRepository.findAll();
    }

    public Optional<UserEntity> findUserById(Integer id) {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("ID는 0보다 커야 합니다.");
        }

        return userRepository.findById(id);
    }

    public Optional<UserEntity> saveUser(UserEntity userEntity) {
        // 유효성 검증 로직 (필요에 따라 추가)
        if (userEntity.getUserName() == null || userEntity.getUserName().length() != 3) {
            throw new IllegalArgumentException("이름은 3글자여야 합니다.");
        }
        if (userEntity.getUserAge() == null || userEntity.getUserAge() < 20) {
            throw new IllegalArgumentException("회원의 나이는 20살 이상이여야 합니다.");
        }
        if (userEntity.getAddressPost() == null || !userEntity.getAddressPost().matches("\\d{5}")) {
            throw new IllegalArgumentException("우편번호는 5자리 숫자여야 합니다.");
        }

        // 데이터베이스에 UserEntity 저장
        UserEntity savedUser = userRepository.save(userEntity);

        // Optional로 반환
        return Optional.of(savedUser);
    }
}
