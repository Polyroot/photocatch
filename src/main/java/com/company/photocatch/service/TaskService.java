package com.company.photocatch.service;

import com.company.photocatch.domain.Task;
import com.company.photocatch.repos.TasksRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskService {

    @Autowired
    private TasksRepo tasksRepo;

    public void changeStatusTask(Task task, String taskstatus){


        task.setTaskstatus(taskstatus);

        tasksRepo.save(task);

    }

}
