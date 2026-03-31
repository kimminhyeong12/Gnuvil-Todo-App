package com.gnuvil.todo_list;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter @Setter
public class Todo {
    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private boolean completed;
    private LocalDateTime createdAt;

    public void setComplete(boolean completed){
        this.completed = completed;
    }



}
