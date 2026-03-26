package com.gnuvil.todo_list;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class TodoService {

    private final TodoRepository todoRepository;

    public Long join(Todo todo) {
        BlankInspection(todo);
        todoRepository.save(todo);
        return todo.getId();


    }


    public void BlankInspection(Todo todo) {
        String name = todo.getName();
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException();
        }
    }

}
