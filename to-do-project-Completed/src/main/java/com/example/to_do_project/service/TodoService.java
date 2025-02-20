package com.example.to_do_project.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

import com.example.to_do_project.todo.Todo;

import jakarta.validation.Valid;

@Service
public class TodoService {
	
	private static List<Todo> todos = new ArrayList<>();
	
	private static int todosCount = 0;
	static {
		todos.add(new Todo(++todosCount, "in28minutes","learn Aws Certified",LocalDate.now().plusYears(1),false));
		todos.add(new Todo(++todosCount, "in28minutes","learnDevps",LocalDate.now().plusYears(2),false));
		todos.add(new Todo(++todosCount, "in28minutes","learn full stack development",LocalDate.now().plusYears(3),false));
	}
	
	public List<Todo> findByUsername(String username){
		return todos;
	}
	public void addTodo(String username, String description, LocalDate targetDate, boolean Done) {
		Todo todo = new Todo(++todosCount,username,description,targetDate,Done);
		todos.add(todo);
	}
	
	public void deleteById(int id) {
		Predicate<? super Todo> predicate = todo ->todo.getId() == id;
		todos.removeIf(predicate);
	}
	public Todo findById(int id) {
		Predicate<? super Todo> predicate = todo -> todo.getId()==id;
		Todo todo = todos.stream().filter(predicate).findFirst().get();
		return todo;
	}
	public void updateTodo(@Valid Todo todo) {
		deleteById(todo.getId());
		todos.add(todo);
		
	}

}
