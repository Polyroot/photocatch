package com.company.photocatch.controller;

import com.company.photocatch.domain.Task;
import com.company.photocatch.domain.User;
import com.company.photocatch.repos.TasksRepo;
import com.company.photocatch.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/studiotasks")
@PreAuthorize("hasAuthority('ADMIN')")
public class StudioTasksController {

    @Autowired
    private TasksRepo tasksRepo;

    @Autowired
    private TaskService taskService;

    @GetMapping
    public String getStudioTasks(Model model){

        model.addAttribute("tasks", tasksRepo.findAll());

        return "studioTasks";
    }

    @PostMapping
    public String addTasks(Model model,
                           @RequestParam String taskname,
                           @RequestParam String product,
                           @RequestParam String description,
                           @RequestParam String address,
                           @AuthenticationPrincipal User user){

        Task task = new Task(taskname, product, description, address, user);

        taskService.changeStatusTask(task);
        model.addAttribute("tasks", tasksRepo.findAll());

        return "studioTasks";
    }

}
