package com.project.todoserver.service;

import com.project.todoserver.dto.TodoResponse;
import com.project.todoserver.entity.Todo;
import com.project.todoserver.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class TodoService {

    private final TodoRepository todoRepository;

    @Transactional(readOnly = true)
    public TodoResponse getById(Long id) {
        Todo todo = todoRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return TodoResponse.entityToDto(todo);
    }

    @Transactional(readOnly = true)
    public List<TodoResponse> getAll() {
        return todoRepository.findAll().stream()
                .map(TodoResponse::entityToDto)
                .collect(Collectors.toList());
    }

    public TodoResponse createTodo(Todo todo) {
        Todo save = todoRepository.save(todo);
        return TodoResponse.entityToDto(save);
    }

    public TodoResponse updateTodo(Long id,Todo todo) {
        Todo findTodo = getEntityById(id);
        if(todo.getTitle() != null){
            findTodo.setTitle(todo.getTitle());
        }
        if(todo.getTodo_order() != null){
            findTodo.setTodo_order(todo.getTodo_order());
        }
        if(todo.getCompleted() != null){
            findTodo.setCompleted(todo.getCompleted());
        }
        return TodoResponse.entityToDto(findTodo);
    }

    public void deleteTodo(Long id){
        todoRepository.deleteById(id);
    }

    public void deleteTodoAll(){
        todoRepository.deleteAll();
    }


    @Transactional(readOnly = true)
    public Todo getEntityById(Long id) {
        return todoRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }



}
