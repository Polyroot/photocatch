package com.company.photocatch.service;

import com.company.photocatch.domain.Task;
import com.company.photocatch.repos.TasksRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskService {

    @Autowired
    private TasksRepo tasksRepo;

    public void changeStatusTask(Task task){

        String status1 = "published";
        String status2 = "performed";
        String status3 = "fulfilled";

        if (task.getTaskstatus() == null){
            task.setTaskstatus(status1);
        } else if (task.getTaskstatus().equals(status1)){
            task.setTaskstatus(status2);
        } else if (task.getTaskstatus().equals(status2)){
            task.setTaskstatus(status3);
        }

        tasksRepo.save(task);
    }
}
