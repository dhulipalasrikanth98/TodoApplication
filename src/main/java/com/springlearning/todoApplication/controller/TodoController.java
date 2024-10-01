package com.springlearning.todoApplication.controller;

import com.springlearning.todoApplication.entity.Todo;
import com.springlearning.todoApplication.service.TodoService;

import jakarta.validation.Valid;

import org.eclipse.tags.shaded.org.apache.xpath.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.security.Security;
import java.time.LocalDate;
import java.util.List;

import javax.swing.Spring;

@Controller
@SessionAttributes("username")
public class TodoController {
	@Autowired
	TodoService todoService;

	@RequestMapping(value = "/todo/lists")
	public String getTodoList(ModelMap model) {

		model.addAttribute("todo", todoService.getByUsername(getLoggedInUser()));
		return "data";
	}

	@RequestMapping(value = "/todo/add", method = RequestMethod.GET)
	public String addTodo(ModelMap model) {

		model.addAttribute("todo", new Todo(0, getLoggedInUser(), "", LocalDate.now().plusYears(1), false));
		return "addtodo";
	}

	@RequestMapping(value = "/todo/add", method = RequestMethod.POST)
	public String redirectToList(ModelMap model, @Valid Todo todo, BindingResult br) {
		if (!br.hasErrors()) {
			todoService.addToTodoList(getLoggedInUser(), todo);
			return "redirect:/todo/lists";
		} else
			return "addtodo";

	}

	@RequestMapping(value = "/todo/delete")
	public String deleteTask(@RequestParam int id) {

		todoService.deleteUser(id);
		return "redirect:/todo/lists";

	}

	@RequestMapping(value = "/todo/update", method = RequestMethod.GET)
	public String getUpdateTodoPage(ModelMap model, @RequestParam int id) {
		Todo todo = todoService.getTodoById(id);
		model.addAttribute("todo", todo);
		return "addtodo";

	}

	@RequestMapping(value = "/todo/update", method = RequestMethod.POST)
	public String updateTodo(ModelMap model, @Valid Todo todo, BindingResult br) {

		if (!br.hasErrors()) {
			todo.setUsername((String) model.get("username"));
			todoService.updateTodo(todo);
			return "redirect:/todo/lists";
		} else
			return "addtodo";

	}

	private String getLoggedInUser() {
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		System.out.println("loggedIn user " + username);
		return username;
	}
	
}
