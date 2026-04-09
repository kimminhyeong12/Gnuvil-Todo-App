package com.gnuvil.todo_list;

import com.gnuvil.todo_list.domain.Todo;
import com.gnuvil.todo_list.domain.User;
import com.gnuvil.todo_list.repository.TodoRepository;
import com.gnuvil.todo_list.service.TodoService;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
    @Transactional
    public void 할일추가(){
        Todo todo = new Todo();
        todo.setName("과제1");
        todo.setCompleted(true);
        User user = new User();
        user.setId(123L);
        user.setPasswd("213");
        Long id = user.getId();
        todoService.join(id,todo);
    }

    @Test
    public void 공백검사(){
        Todo todo = new Todo();
        todo.setName("");
        User user = new User();
        user.setId(123L);
        user.setPasswd("213");
        Long id = user.getId();

        Assertions.assertThrows(IllegalArgumentException.class, () ->
                todoService.join(id,todo));
    }
    @Test
    public void 조회(){
        Todo todo = new Todo();
        todo.setName("과제2");
        User user = new User();
        user.setId(123L);
        user.setPasswd("213");
        Long id = user.getId();
        todoService.join(id,todo);

        Todo todo2 = new Todo();
        todo2.setName("과제3");
        todoService.join(id,todo2);

        List<Todo> all = todoService.findAll();
        System.out.println("all = " + all);
    }

}