package com.company.photocatch.controller;

import com.company.photocatch.DTO.TaskDTO;
import com.company.photocatch.domain.Task;
import com.company.photocatch.domain.User;
import com.company.photocatch.repos.TasksRepo;
import com.company.photocatch.service.TaskService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

@Controller
@Scope(value = "session")
@RequestMapping("/studiotasks")
@PreAuthorize("hasAuthority('ADMIN')")
public class StudioTasksController {

    private static final Logger log = LoggerFactory.getLogger(StudioTasksController.class);

    @Autowired
    private TasksRepo tasksRepo;

    @Autowired
    private TaskService taskService;

    @GetMapping()
    public String getStudioTasks(Model model, @AuthenticationPrincipal User user){

        model.addAttribute("task", tasksRepo.getTaskMaxId(user.getId()));

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
        model.addAttribute("task", task);

        return "studiotasks";
    }


//
//    @PostMapping
//    public String addTask(Model model, @RequestBody TaskDTO taskDTO,
//                           @AuthenticationPrincipal User user){
//        log.info("addTask " + taskDTO);
//        taskDTO.setUser(user);
//        task = Task.createTask(taskDTO);
//        taskService.changeStatusTask(taskDTO);
//
//        model.addAttribute("task", task);
//
//        return "studiotasks";
//    }

}
