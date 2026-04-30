package com.gnuvil.todo_list;

import com.gnuvil.todo_list.domain.Todo;
import com.gnuvil.todo_list.domain.User;
import com.gnuvil.todo_list.repository.TodoRepository;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
@Rollback(value = false)
class TodoRepositoryTest {
    @Autowired
    EntityManager em;
    @Autowired
    TodoRepository todoRepository;

    @Test
    public void 할일추가() {
        Todo todo = new Todo();
        todo.setName("과제");
        todo.setCompleted(false);
        User user = new User();
        user.setId(123L);
        user.setPasswd("123");
        Long id = user.getId();
        User findUser = todoRepository.findUserById(id);
        todo.setUser(findUser);
        em.flush();
        em.clear();
        System.out.println("todo = " + todo.getName());
        Todo findTodo = em.find(Todo.class, todo.getId());

        org.assertj.core.api.Assertions.assertThat(todo.getId()).isEqualTo(findTodo.getId());
    }


}