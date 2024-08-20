package com.test.springrepeat.user.controller;


import com.test.springrepeat.user.entity.UserEntity;
import com.test.springrepeat.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/user")
public class UserController {

    private final UserService Service;

    @Autowired
    public UserController(UserService Service) {
        this.Service = Service;
    }

    //전체조회
    @GetMapping
    public ResponseEntity<List<UserEntity>> getAllUser(){
        List<UserEntity> user = Service.findAllUser();
        if(user.isEmpty()){
            return ResponseEntity.status(404)
                    .header("message","등록된 유저가 없습니다.")
                    .build();
        }
        return ResponseEntity.ok(user);
    }
    //상세 조회
    @GetMapping("/{id}")
    public ResponseEntity<UserEntity> getUserById(@PathVariable Integer id) {
        try {
            Optional<UserEntity> getUser = Service.findUserById(id);
            return getUser.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.status(404)
                    .header("message", "조회한 유저의 데이터가 없습니다.")
                    .build());
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(400)
                    .header("message", e.getMessage())
                    .build();
        }
    }





}
