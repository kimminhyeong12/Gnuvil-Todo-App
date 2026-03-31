package com.gnuvil.todo_list.controller;

import com.gnuvil.todo_list.Todo;
import com.gnuvil.todo_list.TodoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todos")
@RequiredArgsConstructor
public class TodoController {

    private final TodoService todoService;

    @GetMapping
    public List<Todo> getTodos() {
        return todoService.findAll();
    }

    @PostMapping //post 요청 처리
    public Long makeTodos(@RequestBody Todo todo) { //RequestBody는 json을 객체로 변환
        return todoService.join(todo);
    }

    @PatchMapping("/{id}")
    public Todo toggleTodo(@PathVariable Long id) { //PathVariable은 URL에서 자동으로 id를 끌어다옴
        return todoService.completeTodo(id);
    }

    @DeleteMapping("/{id}")
    public void deleteTodo(@PathVariable Long id) {
        todoService.deleteTodo(id);
    }
}
