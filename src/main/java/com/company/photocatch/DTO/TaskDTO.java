package com.company.photocatch.DTO;

import com.company.photocatch.domain.User;

import java.util.List;

public class TaskDTO {

    private Long id;
    private String taskname;

    private String product;
    private String description;
    private String address;
    private String taskstatus;
    private User user;

    private List<String> photonames;

    public TaskDTO(Long id, String taskname, String product, String description, String address, String taskstatus, User user, List<String> photonames) {
        this.id = id;
        this.taskname = taskname;
        this.product = product;
        this.description = description;
        this.address = address;
        this.taskstatus = taskstatus;
        this.user = user;
        this.photonames = photonames;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTaskname() {
        return taskname;
    }

    public void setTaskname(String taskname) {
        this.taskname = taskname;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTaskstatus() {
        return taskstatus;
    }

    public void setTaskstatus(String taskstatus) {
        this.taskstatus = taskstatus;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<String> getPhotonames() {
        return photonames;
    }

    public void setPhotonames(List<String> photonames) {
        this.photonames = photonames;
    }

    @Override
    public String toString() {
        return "TaskDTO{" +
                "id=" + id +
                ", taskname='" + taskname + '\'' +
                ", product='" + product + '\'' +
                ", description='" + description + '\'' +
                ", address='" + address + '\'' +
                ", taskstatus='" + taskstatus + '\'' +
                ", user=" + user +
                ", photonames=" + photonames +
                '}';
    }
}