package com.gnuvil.todo_list.controller;

import com.gnuvil.todo_list.domain.LoginRequest;
import com.gnuvil.todo_list.domain.LoginResponse;
import com.gnuvil.todo_list.domain.User;
import com.gnuvil.todo_list.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController//
@RequestMapping("/api/users")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:5173")
public class UserController {
    private final UserService userService;

    @PostMapping("/signup")
    public Long join(@RequestBody User user) { //@RequestBody는 Json 데이터를 객체로 변환
        return userService.join(user);
    }

    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest request) {
        return userService.login(request);
    }

    @GetMapping("/{id}")
    public User findOne(@PathVariable Long id) {
        return userService.findOne(id);
    }
    @GetMapping
    public List<User> findAll(){
        return userService.findAll();
    }


}
