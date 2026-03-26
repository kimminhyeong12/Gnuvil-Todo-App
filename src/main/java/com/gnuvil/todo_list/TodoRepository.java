package com.gnuvil.todo_list;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class TodoRepository {
    private final EntityManager em;

    public void save(Todo todo) {
        em.persist(todo);

    }

    public Todo findById(Long id) {
        Todo todo = em.find(Todo.class, id);
        return todo;
    }
    public List<Todo> findAll(){
        return em.createQuery("select t from Todo t", Todo.class)
                .getResultList();
    }

    public void remove(Todo todo) {
        em.remove(todo);
    }


}
