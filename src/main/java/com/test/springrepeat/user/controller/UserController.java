package com.test.springrepeat.user.controller;

import com.test.springrepeat.user.entity.UserEntity;
import com.test.springrepeat.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<UserEntity>> findAllUser() {
        List<UserEntity> users = userService.findAllUser();
        return ResponseEntity.ok(users);
    }
}
