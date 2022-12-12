package com.project.todoserver.dto;

import com.project.todoserver.entity.Todo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TodoResponse {
    private Long id;

    private String title;

    private Long todo_order;

    private Boolean completed;

    private String url;

    public static TodoResponse entityToDto(Todo todo) {
        return new TodoResponse(
                todo.getId(),
                todo.getTitle(),
                todo.getTodo_order(),
                todo.getCompleted(),
                "http://localhost:8080/" + todo.getId()
        );
    }
}
