package com.test.springrepeat.user.service;

import com.test.springrepeat.user.entity.UserEntity;
import com.test.springrepeat.user.model.UserDTO;
import com.test.springrepeat.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public List<UserEntity> findAllUsers() {
        return userRepository.findAll();
    }

    @Transactional
    public Optional<UserEntity> findUserById(Integer id) {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("ID는 0보다 커야 합니다.");
        }
        return userRepository.findById(id);
    }

    @Transactional
    public Optional<UserEntity> saveUser(UserDTO userDto) {
        UserEntity userEntity = UserEntity.builder()
                .userName(userDto.getUserName())
                .userAge(userDto.getUserAge())
                .addressPost(userDto.getAddressPost())
                .addressDefault(userDto.getAddressDefault())
                .addressDetail(userDto.getAddressDetail())
                .userCreateAt(LocalDateTime.now())
                .userUpdateAt(LocalDateTime.now())
                .build();

        validateUser(userEntity);
        UserEntity savedUser = userRepository.save(userEntity);
        return Optional.of(savedUser);
    }

    @Transactional
    public UserEntity updateUser(Integer id, UserDTO userDto) {
        UserEntity findUser = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 ID의 유저를 찾을 수 없습니다."));

        UserEntity updatedUser = UserEntity.builder()
                .id(findUser.getId())
                .userName(userDto.getUserName() != null ? userDto.getUserName() : findUser.getUserName())
                .userAge(userDto.getUserAge() != null ? userDto.getUserAge() : findUser.getUserAge())
                .addressPost(userDto.getAddressPost() != null ? userDto.getAddressPost() : findUser.getAddressPost())
                .addressDefault(userDto.getAddressDefault() != null ? userDto.getAddressDefault() : findUser.getAddressDefault())
                .addressDetail(userDto.getAddressDetail() != null ? userDto.getAddressDetail() : findUser.getAddressDetail())
                .userCreateAt(findUser.getUserCreateAt())
                .userUpdateAt(LocalDateTime.now())
                .build();

        validateUser(updatedUser);
        return userRepository.save(updatedUser);
    }

    private void validateUser(UserEntity userEntity) {
        if (userEntity.getUserName() == null || userEntity.getUserName().length() != 3) {
            throw new IllegalArgumentException("이름은 3글자여야 합니다.");
        }
        if (userEntity.getUserAge() == null || userEntity.getUserAge() < 20) {
            throw new IllegalArgumentException("회원의 나이는 20살 이상이어야 합니다.");
        }
        if (userEntity.getAddressPost() == null || !userEntity.getAddressPost().matches("\\d{5}")) {
            throw new IllegalArgumentException("우편번호는 5자리 숫자여야 합니다.");
        }
    }
}
