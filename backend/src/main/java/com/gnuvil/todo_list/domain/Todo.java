package com.gnuvil.todo_list.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

import static jakarta.persistence.FetchType.*;

@Entity
@Getter @Setter
public class Todo {
    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private boolean completed;
    private LocalDateTime createdAt;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;

    public void setComplete(boolean completed) {
        this.completed = completed;
    }



}
