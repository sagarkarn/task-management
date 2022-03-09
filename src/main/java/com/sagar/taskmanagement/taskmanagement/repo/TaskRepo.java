package com.sagar.taskmanagement.taskmanagement.repo;

import com.sagar.taskmanagement.taskmanagement.model.Task;

import org.springframework.data.repository.CrudRepository;

public interface TaskRepo extends CrudRepository<Task, Long> {

}
