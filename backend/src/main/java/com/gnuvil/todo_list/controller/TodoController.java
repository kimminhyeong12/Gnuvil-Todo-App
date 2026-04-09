package com.gnuvil.todo_list.controller;

import com.gnuvil.todo_list.domain.Todo;
import com.gnuvil.todo_list.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/todos")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:5173") //외부 도메인 허용
public class TodoController {

    private final TodoService todoService;

    public record TodoRequest(String name){

    }

    @GetMapping("/{id}")
    public List<Todo> getTodos(@PathVariable Long id) {
        return todoService.findMyTodos(id);
    }

    @PostMapping
    public Long createTodo(@RequestBody Todo todo) {
        return todoService.join(todo);
    }

    @PutMapping("/{id}")
    public void changeTodo(@PathVariable Long id, @RequestBody TodoRequest request){
        todoService.changeTodo(id, request.name());
    }

    @PatchMapping("/{id}")
    public Todo toggleTodo(@PathVariable Long id) {
        return todoService.completeTodo(id);
    }

    @DeleteMapping("/{id}")
    public void deleteTodo(@PathVariable Long id) {
        todoService.deleteTodo(id);
    }
}
