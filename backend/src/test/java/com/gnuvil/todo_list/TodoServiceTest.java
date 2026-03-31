package com.gnuvil.todo_list;

import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

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
        todoRepository.save(todo);
        todoService.join(todo);
    }

    @Test
    public void 공백검사(){
        Todo todo = new Todo();
        todo.setName("");

        Assertions.assertThrows(IllegalArgumentException.class, () ->
                todoService.join(todo));
    }
    @Test
    public void 조회(){
        Todo todo = new Todo();
        todo.setName("과제2");
        todoService.join(todo);

        Todo todo2 = new Todo();
        todo2.setName("과제3");
        todoService.join(todo2);

        List<Todo> all = todoService.findAll();
        System.out.println("all = " + all);


    }

}