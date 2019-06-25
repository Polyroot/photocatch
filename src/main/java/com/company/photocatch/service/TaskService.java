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
            task.setTaskstatus("published");
        } else if (task.getTaskstatus().equals("published")){
            task.setTaskstatus("performed");
        } else if (task.getTaskstatus().equals("performed")){
            task.setTaskstatus("fulfilled");
        }

        tasksRepo.save(task);
    }
}
