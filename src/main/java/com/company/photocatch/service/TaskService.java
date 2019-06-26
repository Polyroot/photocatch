package com.company.photocatch.service;

import com.company.photocatch.domain.Task;
import com.company.photocatch.domain.Test;
import com.company.photocatch.repos.TasksRepo;
import com.company.photocatch.repos.TestRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Service
public class TaskService {

    @Autowired
    private TasksRepo tasksRepo;

    @Value("${upload.path}")
    private String photoUploadPath;

    public void changeStatusTask(Task task){

        final String status1 = "published";
        final String status2 = "performed";
        final String status3 = "fulfilled";

        if (task.getTaskstatus() == null){
            task.setTaskstatus(status1);
        } else if (task.getTaskstatus().equals(status1)){
            task.setTaskstatus(status2);
        } else if (task.getTaskstatus().equals(status2)){
            task.setTaskstatus(status3);
        }

        tasksRepo.save(task);
    }

    public void addPhotos(Task task, MultipartFile photoFile) throws IOException {

        if (photoFile!=null){

            File photoUploadDir = new File(photoUploadPath);
            if (!photoUploadDir.exists()){
                photoUploadDir.mkdir();
            }

            String photoUUIDFile = UUID.randomUUID().toString();
            String photoFileName = photoUUIDFile + "." + photoFile.getOriginalFilename();

            photoFile.transferTo(new File(photoUploadDir + "/" + photoFileName));
            task.setPhotoname(photoFileName);
        }

        tasksRepo.save(task);
    }



}
