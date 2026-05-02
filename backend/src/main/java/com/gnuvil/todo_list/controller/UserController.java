package com.gnuvil.todo_list.controller;

import com.gnuvil.todo_list.domain.LoginRequest;
import com.gnuvil.todo_list.domain.LoginResponse;
import com.gnuvil.todo_list.domain.SignupRequest;
import com.gnuvil.todo_list.domain.User;
import com.gnuvil.todo_list.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController//
@RequestMapping("/api/users")
@RequiredArgsConstructor
@CrossOrigin(originPatterns = {"http://localhost:*", "http://127.0.0.1:*", "https://*.vercel.app"})
public class UserController {
    private final UserService userService;

    @PostMapping("/signup")
    public Long join(@RequestBody SignupRequest request) { //@RequestBody는 Json 데이터를 객체로 변환
        return userService.join(request);
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
