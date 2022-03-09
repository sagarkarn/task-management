package com.sagar.taskmanagement.taskmanagement.controller;

import java.util.Date;

import com.sagar.taskmanagement.taskmanagement.model.Task;
import com.sagar.taskmanagement.taskmanagement.repo.TaskRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @Autowired
    TaskRepo repo;

    @RequestMapping("/")
    public String index() {
        return "index";
    }

}
