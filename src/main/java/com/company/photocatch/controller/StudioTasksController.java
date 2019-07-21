package com.company.photocatch.controller;

import com.company.photocatch.DTO.TaskDTO;
import com.company.photocatch.domain.Task;
import com.company.photocatch.domain.User;
import com.company.photocatch.repos.TasksRepo;
import com.company.photocatch.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/studiotasks")
@PreAuthorize("hasAuthority('ADMIN')")
public class StudioTasksController {

    @Autowired
    private TasksRepo tasksRepo;

    @Autowired
    private TaskService taskService;

    private Task task;
    //спросить так можно или это говнокодно и нужно через репозитароий доставать
    // (делать селект последней задачи для юзера текущей сессии)

    @GetMapping()
    public String getStudioTasks(Model model){

        model.addAttribute("task", task);

        return "studioTasks";
    }

    @PostMapping
    public String addTasks(Model model,
                           @RequestParam String taskname,
                           @RequestParam String product,
                           @RequestParam String description,
                           @RequestParam String address,
                           @AuthenticationPrincipal User user){

        task = new Task(taskname, product, description, address, user);

        taskService.changeStatusTask(task);
        model.addAttribute("task", task);

        return "studiotasks";
    }

//    @GetMapping()
//    public String getStudioTasks(Model model, TaskDTO taskDTO){
//
//        model.addAttribute("task", taskDTO);
//
//        return "studioTasks";
//    }
//
//    @PostMapping
//    public String addTasks(Model model, @ModelAttribute("task") TaskDTO taskDTO,
//                           @AuthenticationPrincipal User user){
//        taskDTO.setUser(user);
//        task = Task.createTask(taskDTO);
//        taskService.changeStatusTask(taskDTO);
//        System.out.println(taskDTO);
//        model.addAttribute("task", task);
//
//        return "studiotasks";
//    }

}
