package com.gnuvil.todo_list.controller;

import com.gnuvil.todo_list.domain.Todo;
import com.gnuvil.todo_list.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/todos")
@RequiredArgsConstructor
@CrossOrigin(originPatterns = {"http://localhost:*", "http://127.0.0.1:*"}) //외부 도메인 허용
public class TodoController {

    private final TodoService todoService;

    public record TodoRequest(String name){

    }
//PathVariable이 아니라 Login 한 사용자의 객체에서 id를 꺼내와야함

    @GetMapping
    public List<Todo> getTodos(@RequestAttribute("id") Long id) {
        return todoService.findMyTodos(id);
    }

    @PostMapping
    public Long createTodo(@RequestAttribute("id") Long id, @RequestBody TodoRequest todo) {
        return todoService.join(id, todo.name());
    }

    @PutMapping
    public void changeTodo(@PathVariable Long id, @RequestBody TodoRequest request) {
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
