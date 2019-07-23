package com.company.photocatch.controller;


import com.company.photocatch.domain.Task;
import com.company.photocatch.domain.User;
import com.company.photocatch.repos.TasksRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user-tasks/{user}")
public class UserTaskController {

    @Autowired
    private TasksRepo tasksRepo;

    @GetMapping()
    public String userTasks(@AuthenticationPrincipal User currentUser,
                            @PathVariable User user,
                            Model model,
                            @RequestParam(required = false) Task task){
        model.addAttribute("tasks", user.getTasks());
        model.addAttribute("task", task);
        model.addAttribute("isCurrentUser", currentUser.equals(user));

        return "usrTasks";
    }

    @PostMapping()
    public String updateTask(@AuthenticationPrincipal User currentUser,
                             @PathVariable User user,
                             @RequestParam("id") Task task,
                             @RequestParam("taskname") String taskname,
                             @RequestParam("product") String product,
                             @RequestParam("description") String description,
                             @RequestParam("address") String address){

        if (task.getUser().equals(currentUser)){
            if (!StringUtils.isEmpty(taskname)){
                task.setTaskname(taskname);
            }
            if (!StringUtils.isEmpty(product)){
                task.setProduct(product);
            }
            if (!StringUtils.isEmpty(description)){
                task.setDescription(description);
            }
            if (!StringUtils.isEmpty(address)){
                task.setAddress(address);
            }
            tasksRepo.save(task);
        }
        return "redirect:/user-tasks/" + user.getId();
    }
}
