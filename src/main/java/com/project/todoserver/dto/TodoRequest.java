package com.project.todoserver.dto;

import com.project.todoserver.entity.Todo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class TodoRequest {

    private String title;

    private Long todo_order;

    private Boolean completed;

    public Todo dtoToEntity() {
        return new Todo(
                this.title,
                this.todo_order,
                this.completed
        );
    }
}
