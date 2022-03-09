package com.sagar.taskmanagement.taskmanagement.repo;

import com.sagar.taskmanagement.taskmanagement.model.TaskDesc;

import org.springframework.data.repository.CrudRepository;

public interface TaskDescRepo extends CrudRepository<TaskDesc, Long> {

}
