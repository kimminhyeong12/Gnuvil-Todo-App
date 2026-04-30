package com.gnuvil.todo_list.service;

import com.gnuvil.todo_list.domain.Todo;
import com.gnuvil.todo_list.repository.TodoRepository;
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
    public Long join(Long id, String name) {
        BlankInspection(name);
        Todo todo = new Todo();
        todo.setName(name);
        todo.setCompleted(false);
        todoRepository.save(id, todo);
        return todo.getId();
    }

    public void BlankInspection(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("name은 비어 있을 수 없습니다.");
        }
    }

    public List<Todo> findAll() {
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

    @Transactional
    public void changeTodo(Long id, String name) {
        Todo findTodo = todoRepository.findById(id);
        findTodo.setName(name);
    }

    @Transactional(readOnly = true)
    public List<Todo> findMyTodos(Long id) {
        return todoRepository.findByUserId(id);
    }
}
