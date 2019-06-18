package com.company.photocatch.controller;


import com.company.photocatch.domain.Task;
import com.company.photocatch.repos.TasksRepo;
import com.company.photocatch.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/task")
public class TaskController {

    @Autowired
    private TasksRepo tasksRepo;

    @Autowired
    private TaskService taskService;


    @GetMapping("{task}")
    public String getTask(@PathVariable Task task, Model model){

        model.addAttribute("task", task);

        return "task";

    }

    @PostMapping()
    public String changeStatusTask(@RequestParam("taskId") Task task, Model model){

        taskService.changeStatusTask(task, "performed");

        model.addAttribute("task", task);

        return "task";
    }







}
