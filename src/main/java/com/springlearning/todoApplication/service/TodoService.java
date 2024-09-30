package com.springlearning.todoApplication.service;

import com.springlearning.todoApplication.entity.Todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TodoService {
    private static List<Todo> todoList = new ArrayList<>();

 static {
      todoList.add(new Todo(1,"srikanth","Learn Spring Boot", LocalDate.now().plusYears(1),false));
      todoList.add(new Todo(2,"rajesh","Learn AWS", LocalDate.now().plusYears(1),false));
      todoList.add(new Todo(3,"ravi","Learn Docker", LocalDate.now().plusYears(1),false));
      todoList.add(new Todo(4,"kiran","Learn Jenkins", LocalDate.now().plusYears(1),false));

    }

    public  void addToTodoList(String username,String description, LocalDate target, boolean isDone) {
        int last = todoList.size() + 1;
        todoList.add(new Todo(last,username,description,target,isDone));
    }

    public  List<Todo> getAllTodo() {
        return todoList;
    }
    public  void deleteUser(int id) {
    	todoList.removeIf(todo-> todo.getId() == id);
    }

	public Todo getTodoById(int id) {
		Todo todo1 = todoList.stream().filter(todo->todo.getId() == id).findFirst().get();
		System.out.println("todo old data" + todo1);
		return todo1;
	}

	public void updateTodo(Todo newTodo) {
		int index  = -1;
		for(int i = 0; i < todoList.size(); i++) {
			if(newTodo.getId() == todoList.get(i).getId()) {
				index = i;
				break;
			}
		}
		System.out.println("newTodo"+newTodo);
		if(index != -1)
		todoList.set(index, newTodo);
//		deleteUser(newTodo.getId());
//		addToTodoList(username, newTodo.getDescription(), newTodo.getTarget(), newTodo.isDone());
		
	}

	public List<Todo> getByUsername(String loggedInUser) {
		System.out.println("getbyusername"+todoList);
		List<Todo> todos = todoList.stream()
				                   .filter(todo->todo.getUsername().equalsIgnoreCase(loggedInUser))
				                   .toList();
		return todos;
	}
}
