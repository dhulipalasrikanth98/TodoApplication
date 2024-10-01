package com.springlearning.todoApplication.entity;



import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Size;

@Entity(name = "TODO")
public class Todo {
	@Id
	@GeneratedValue
    private int id;
    private String username;
    @Size(min = 10,message = "maximum description size should be 10 characters")
    private String description;
    private LocalDate target;
    private boolean done;

    public Todo(int id, String username, String description, LocalDate target, boolean done) {
        this.id = id;
        this.username = username;
        this.description = description;
        this.target = target;
        this.done = done;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getTarget() {
        return target;
    }

    public void setTarget(LocalDate target) {
        this.target = target;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    @Override
    public String toString() {
        return "Todo{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", description='" + description + '\'' +
                ", target=" + target +
                ", done=" + done +
                '}';
    }
    public Todo(){
    	
    }
}
