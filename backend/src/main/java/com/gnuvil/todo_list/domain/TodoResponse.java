package com.gnuvil.todo_list.domain;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class TodoResponse {
    private Long id;
    private String name;
    private Boolean completed;
    private LocalDateTime createdAt;

}
