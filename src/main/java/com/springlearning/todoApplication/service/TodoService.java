package com.springlearning.todoApplication.service;

import com.springlearning.todoApplication.entity.Todo;
import com.springlearning.todoApplication.service.repo.TodoRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoService {
    private static List<Todo> todoList = new ArrayList<>();
    private TodoRepository todoRepository;
    @Autowired
    public TodoService(TodoRepository todoRepository) {
    	this.todoRepository = todoRepository;
    }

    public  void addToTodoList(String username,Todo todo) {
        todo.setUsername(username);
        todoRepository.save(todo);
    }

    public  List<Todo> getAllTodo() {
        return todoRepository.findAll();
    }
    public  void deleteUser(int id) {
    	
    	todoRepository.deleteById(id);
    }

	public Todo getTodoById(int id) {
		return todoRepository.findById(id).get();
	}

	public void updateTodo(Todo newTodo) {
		todoRepository.save(newTodo);
		
	}

	public List<Todo> getByUsername(String loggedInUser) {
		return todoRepository.findByUsername(loggedInUser);
		
	}
}
