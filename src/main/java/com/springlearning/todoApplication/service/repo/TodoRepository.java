package com.springlearning.todoApplication.service.repo;

import com.springlearning.todoApplication.entity.Todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Integer>{
  List<Todo> findByUsername(String username);
}
