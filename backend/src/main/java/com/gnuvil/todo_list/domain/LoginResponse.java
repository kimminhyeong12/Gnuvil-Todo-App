package com.gnuvil.todo_list.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class LoginResponse {
    private Long id;
    private String email;
    private String name;
    private String message;
}
