package com.project.todoserver.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @Setter
    private String title;

    @Column(nullable = false)
    @Setter
    private Long todo_order;

    @Column(nullable = false)
    @Setter
    private Boolean completed;


    public Todo(String title, Long todo_order, Boolean completed) {
        this.title = title;
        this.todo_order = todo_order;
        this.completed = completed;
    }
}
