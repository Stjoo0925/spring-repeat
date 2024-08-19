package com.test.springrepeat.user.controller;

import com.test.springrepeat.user.entity.UserEntity;
import com.test.springrepeat.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public ResponseEntity<List<UserEntity>> allview() {
        List<UserEntity> users = userService.findAllUser();

        // 사용자 목록이 비어 있는지 확인
        if (users.isEmpty()) {
            return ResponseEntity.status(404)
                    .header("message", "등록된 유저가 없습니다.")
                    .build();
        }

        return ResponseEntity.ok(users);
    }

    @GetMapping("/id")
    public ResponseEntity<UserEntity> detailview(@RequestBody Integer id) {
        // 서비스에서 검증 및 조회 로직 처리
        try {
            Optional<UserEntity> getUser = userService.findUserById(id);

            // 유저의 id가 유효할 경우 실행하는 로직
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
}
