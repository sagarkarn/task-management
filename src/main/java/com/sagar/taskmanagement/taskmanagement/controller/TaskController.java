package com.sagar.taskmanagement.taskmanagement.controller;

import java.text.SimpleDateFormat;
import com.sagar.taskmanagement.taskmanagement.model.Task;
import com.sagar.taskmanagement.taskmanagement.model.TaskDesc;
import com.sagar.taskmanagement.taskmanagement.repo.TaskDescRepo;
import com.sagar.taskmanagement.taskmanagement.repo.TaskRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import lombok.var;

@Controller
public class TaskController {

    @Autowired
    TaskRepo taskRepo;

    @Autowired
    TaskDescRepo taskDescRepo;

    @RequestMapping(method = RequestMethod.GET, path = "/create")
    public String create(Model model) {
        model.addAttribute("task", new Task());
        return "create";
    }

    @PostMapping("/create")
    public String createSubmit(@ModelAttribute Task task, Model model) {

        taskRepo.save(task);

        return "create";
    }

    @GetMapping("/tasks")
    public String getAllTask(Model model) {
        var allTask = taskRepo.findAll();
        model.addAttribute("tasks", allTask);
        return "tasks";
    }

    @GetMapping("/task/{id}")
    public String getTask(@PathVariable("id") long id, Model model) {

        var task = taskRepo.findById(id).get();
        System.out.println(task.getTaskDesc());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");

        model.addAttribute("task", task);
        model.addAttribute("taskDesc", new TaskDesc());
        model.addAttribute("dateformatter", simpleDateFormat);

        return "task";
    }

    @PostMapping("/task/create")
    public String createTaskDesc(TaskDesc taskDesc, Model model) {

        System.out.println(taskDesc);

        taskDescRepo.save(taskDesc);

        return "redirect:/tasks";
    }

}
