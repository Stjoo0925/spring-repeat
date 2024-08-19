package com.test.springrepeat.user.controller;

import com.test.springrepeat.user.entity.UserEntity;
import com.test.springrepeat.user.model.UserDTO;
import com.test.springrepeat.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<UserEntity>> getAllUsers() {
        List<UserEntity> users = userService.findAllUsers();
        if (users.isEmpty()) {
            return ResponseEntity.status(404)
                    .header("message", "등록된 유저가 없습니다.")
                    .build();
        }
        return ResponseEntity.ok(users);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserEntity> getUserById(@PathVariable Integer id) {
        try {
            Optional<UserEntity> getUser = userService.findUserById(id);
            if (getUser.isPresent()) {
                return ResponseEntity.ok(getUser.get());
            } else {
                return ResponseEntity.status(404)
                        .header("message", "조회한 유저의 데이터가 없습니다.")
                        .build();
            }
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(400)
                    .header("message", e.getMessage())
                    .build();
        }
    }

    @PostMapping("/create")
    public ResponseEntity<UserEntity> createUser(@RequestBody UserDTO userDto) {
        try {
            Optional<UserEntity> savedUser = userService.saveUser(userDto);
            if (savedUser.isPresent()) {
                return ResponseEntity.ok(savedUser.get());
            } else {
                return ResponseEntity.status(500)
                        .header("message", "유저 저장에 실패했습니다.")
                        .build();
            }
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(400)
                    .header("message", e.getMessage())
                    .build();
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<UserEntity> updateUser(@PathVariable Integer id, @RequestBody UserDTO userDto) {
        try {
            UserEntity updatedUser = userService.updateUser(id, userDto);
            return ResponseEntity.ok(updatedUser);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(400)
                    .header("message", e.getMessage())
                    .build();
        } catch (Exception e) {
            return ResponseEntity.status(500)
                    .header("message", "유저 업데이트에 실패했습니다.")
                    .build();
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Integer id) {
        try {
            userService.deleteUser(id);
            return ResponseEntity.noContent().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(400)
                    .header("message", e.getMessage())
                    .build();
        } catch (Exception e) {
            return ResponseEntity.status(500)
                    .header("message", "유저 삭제에 실패했습니다.")
                    .build();
        }
    }
}
