package com.company.photocatch.controller;


import com.company.photocatch.domain.User;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user-tasks/{user}")
public class UserTaskController {

    @GetMapping()
    public String userTasks(@AuthenticationPrincipal User currentUser,
                            @PathVariable User user,
                            Model model){
        model.addAttribute("tasks", user.getTasks());
        model.addAttribute("isCurrentUser", currentUser.equals(user));

        return "usrTasks";
    }

}
