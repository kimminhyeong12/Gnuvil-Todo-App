package com.gnuvil.todo_list;

import com.gnuvil.todo_list.domain.Todo;
import com.gnuvil.todo_list.domain.User;
import com.gnuvil.todo_list.repository.TodoRepository;
import com.gnuvil.todo_list.service.TodoService;
import jakarta.persistence.EntityManager;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
@Transactional

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
        Long todo_id = todoService.join(12L, "abc");
        Todo findTodo = todoRepository.findById(todo_id);
        Assertions.assertThat(findTodo.getId()).isEqualTo(todo_id);
        Assertions.assertThat(findTodo.getName()).isEqualTo("abc");
    }

    @Test
    public void 할일조회(){
        User user = new User();
        user.setEmail("minhyeong@gmail.com");
        user.setName("kim");
        user.setPasswd("1234");
        em.persist(user);

        Long todo_id = todoService.join(user.getId(), "aa");   //10L은 user_id이다.
        List<Todo> myTodos = todoService.findMyTodos(user.getId());

        System.out.println("myTodos = " + myTodos);
        Assertions.assertThat(myTodos.get(0).getName()).isEqualTo("aa");
    }


}