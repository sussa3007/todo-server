package com.project.todoserver.repository;

import com.project.todoserver.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TodoRepository extends JpaRepository<Todo,Long>  {
}
