package com.company.photocatch.controller;


import com.company.photocatch.DTO.TaskDTO;
import com.company.photocatch.domain.Task;
import com.company.photocatch.repos.TasksRepo;
import com.company.photocatch.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

        taskService.changeStatusTask(task);

        model.addAttribute("tasks", tasksRepo.findAll());

        return "boardtasks";
    }

//    @GetMapping
//    public String getBoardTask(Model model){
//
//
//        model.addAttribute("tasks", tasksRepo.findAll());
//
//        return "boardTasks";
//    }
//
//    @PostMapping()
//    public String changeStatusTask(@ModelAttribute TaskDTO taskDTO, Model model){
////        System.out.println("taskDTO="+taskDTO);
//
//        taskService.changeStatusTask(taskDTO);
//
//        model.addAttribute("tasks", tasksRepo.findAll());
//
//        return "boardtasks";
//    }
}
