package com.company.photocatch.controller;


import com.company.photocatch.domain.Task;
import com.company.photocatch.repos.TasksRepo;
import com.company.photocatch.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/boardtasks")
public class BoardTasksController {

    @Autowired
    private TasksRepo tasksRepo;

    @Autowired
    private TaskService taskService;

    @GetMapping
    public String getBoardTask(Model model){


        model.addAttribute("tasks", tasksRepo.findAll());

        return "boardTasks";
    }

    @PostMapping
    public String changeStatusTask(@RequestParam("taskId") Task task, Model model){

        taskService.changeStatusTask(task, "performed");
        model.addAttribute("tasks", tasksRepo.findAll());

        return "boardtasks";
    }

}
