package com.gnuvil.todo_list;

import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
//@Transactional
@Rollback(value = false)
class TodoServiceTest {
    @Autowired
    TodoRepository todoRepository;
    @Autowired
    TodoService todoService;
    @Autowired
    EntityManager em;


    @Test
    public void 할일추가(){
        Todo todo = new Todo();
        todo.setName("과제1");
        todo.setCompleted(true);
        todo.setCreatedAt(LocalDateTime.now());
        todoService.join(todo);
    }

    @Test
    public void 공백검사(){
        Todo todo = new Todo();
        todo.setName("");

        Assertions.assertThrows(IllegalArgumentException.class, () ->
                todoService.join(todo));
    }

}