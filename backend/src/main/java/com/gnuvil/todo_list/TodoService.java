package com.gnuvil.todo_list;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class TodoService {

    private final TodoRepository todoRepository;

    @Transactional
    public Long join(Todo todo) {
        BlankInspection(todo);
        todoRepository.save(todo);
        return todo.getId();


    }
    public void BlankInspection(Todo todo) {
        String name = todo.getName();
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("name은 비어 있을 수 없습니다.");
        }
    }
    public List<Todo> findAll(){
        List<Todo> findAll = todoRepository.findAll();
        return findAll;
    }

    @Transactional
    public Todo completeTodo(Long id) {
        Todo todo = todoRepository.findById(id);
        todo.setComplete(!todo.isCompleted());
        return todo;
    }

    @Transactional
    public void deleteTodo(Long id) {
        todoRepository.remove(id);
    }

}
