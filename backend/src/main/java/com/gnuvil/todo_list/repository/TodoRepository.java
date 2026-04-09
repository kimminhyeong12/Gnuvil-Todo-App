package com.gnuvil.todo_list.repository;

import com.gnuvil.todo_list.domain.Todo;
import com.gnuvil.todo_list.domain.User;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class TodoRepository {
    private final EntityManager em;

    public void save(Long id,Todo todo) {
        User findUser = findUserById(id);
        todo.setUser(findUser);
        todo.setCreatedAt(LocalDateTime.now());
        em.persist(todo);
    }

    public Todo findById(Long id) {
        Todo todo = em.find(Todo.class, id);
        return todo;
    }

    public User findUserById(Long id) {
        return em.find(User.class, id);
    }
    public List<Todo> findAll(){
        return em.createQuery("select t from Todo t", Todo.class)
                .getResultList();
    }

    public List<Todo> findByUserId(Long id) {
        return em.createQuery("select t from Todo t where t.user.id = :userId", Todo.class)
                .setParameter("userId", id)
                .getResultList();

    }

    public void remove(Long id) {
        Todo todo = em.find(Todo.class, id);
        em.remove(todo);
    }


}
