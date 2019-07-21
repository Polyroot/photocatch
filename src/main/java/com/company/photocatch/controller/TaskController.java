package com.company.photocatch.controller;


import com.company.photocatch.DTO.TaskDTO;
import com.company.photocatch.domain.Task;
import com.company.photocatch.repos.TasksRepo;
import com.company.photocatch.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

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

        taskService.changeStatusTask(task);
        model.addAttribute("task", task);
        return "redirect:/task/" + task.getId();
    }

//    @PostMapping()
//    public String changeStatusTask(@ModelAttribute("task") TaskDTO taskDTO, Model model){
//
//        System.out.println("TaskDTO = "+ taskDTO);
//        taskService.changeStatusTask(taskDTO);
//        return "redirect:/task/" + taskDTO.getId();
//    }

    @PostMapping("resultphoto")
    public String addPhotos(@RequestParam("taskId") Task task,
                            @RequestParam("photo") MultipartFile photoFile,
                            Model model) throws IOException {

        taskService.addPhotos(task, photoFile);
        model.addAttribute("task", task);
        return "task";
    }
}
