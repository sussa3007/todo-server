package com.project.todoserver.controller;

import com.project.todoserver.dto.TodoRequest;
import com.project.todoserver.dto.TodoResponse;
import com.project.todoserver.service.TodoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequiredArgsConstructor
@RequestMapping("/")
@Slf4j
public class TodoController {

    private final TodoService todoService;

    @PostMapping
    public ResponseEntity<TodoResponse> createTodo(
            @RequestBody TodoRequest request
    ) {
        log.info("Create");
        if (ObjectUtils.isEmpty(request.getTitle()))
            return ResponseEntity.badRequest().build();
        if (ObjectUtils.isEmpty(request.getTodo_order()))
            request.setTodo_order(0L);
        if (ObjectUtils.isEmpty(request.getCompleted()))
            request.setCompleted(false);

        TodoResponse todo = todoService.createTodo(request.dtoToEntity());

        return ResponseEntity.ok(todo);
    }

    @GetMapping
    public ResponseEntity<List<TodoResponse>> getTodoAll() {
        log.info("Read All");
        List<TodoResponse> all = todoService.getAll();

        return ResponseEntity.ok(all);
    }

    @GetMapping("{id}")
    public ResponseEntity<TodoResponse> getOne(
            @PathVariable("id") Long id
    ) {
        log.info("Read One");
        TodoResponse byId = todoService.getById(id);
        return ResponseEntity.ok(byId);
    }

    @PatchMapping("{id}")
    public ResponseEntity<TodoResponse> update(
            @PathVariable("id") Long id,
            @RequestBody TodoRequest request
    ) {
        log.info("Update");
        TodoResponse todoResponse = todoService.updateTodo(id, request.dtoToEntity());
        return ResponseEntity.ok(todoResponse);
    }

    @DeleteMapping("{id}")
    public ResponseEntity delete(
            @PathVariable("id") Long id
    ) {
        log.info("Delete");
        todoService.deleteTodo(id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping
    public ResponseEntity deleteAll() {
        todoService.deleteTodoAll();
        return ResponseEntity.ok().build();
    }

}
