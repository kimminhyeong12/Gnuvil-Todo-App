package com.gnuvil.todo_list.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
@Getter @Setter
public class User {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false,unique = true)
    @Email
    private String email;

    @Column(nullable = false)
    private String passwd;

    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL) //영속성 변화 상태를 연관관계에다가 전달
    private List<Todo> todos = new ArrayList<>();


}
