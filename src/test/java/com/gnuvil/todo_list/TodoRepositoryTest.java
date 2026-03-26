package com.gnuvil.todo_list;

import jakarta.persistence.EntityManager;
import jakarta.validation.constraints.AssertFalse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

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
        todoRepository.save(todo);
        em.flush();
        em.clear();
        System.out.println("todo = " + todo.getName());
        Todo findTodo = em.find(Todo.class, todo.getId());

        org.assertj.core.api.Assertions.assertThat(todo.getId()).isEqualTo(findTodo.getId());
    }


}