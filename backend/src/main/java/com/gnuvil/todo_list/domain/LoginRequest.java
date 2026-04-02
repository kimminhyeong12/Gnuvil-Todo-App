package com.gnuvil.todo_list.domain;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class LoginRequest {
    private String email;
    private String passwd;

}
