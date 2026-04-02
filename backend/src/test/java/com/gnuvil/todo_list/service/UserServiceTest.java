package com.gnuvil.todo_list.service;

import com.gnuvil.todo_list.domain.LoginRequest;
import com.gnuvil.todo_list.domain.LoginResponse;
import com.gnuvil.todo_list.domain.User;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest

class UserServiceTest {

    @Autowired
    UserService userService;
    @Autowired
    LoginRequest loginRequest;
    @Autowired
    LoginResponse loginResponse;
    @Test
    public void 회원추가(){
        User user = new User();
        user.setEmail("minhyeong63@gmail.com");
        user.setPasswd("0000");
        user.setName("김민형");
        userService.join(user);
    }
    @Test
    public void findByEmail(){
        User user = new User();
        user.setEmail("minhyeon@gmail.com");
        user.setPasswd("0000");
        user.setName("김민형");
        userService.join(user);
        String email = user.getEmail();
        Optional<User> findUser = userService.findByEmail(email);
        Assertions.assertThat(user.getId()).isEqualTo(findUser.get().getId());

    }

    @Test
    public void login(){
        User user = new User();
        user.setEmail("minhyeon@gmail.com");
        user.setPasswd("0000");
        user.setName("김민형");
        userService.join(user);


    }


}