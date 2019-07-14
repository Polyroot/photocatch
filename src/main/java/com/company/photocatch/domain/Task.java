package com.company.photocatch.domain;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String taskname;

    private String product;
    private String description;
    private String address;
    private String taskstatus;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "task_photo", joinColumns = @JoinColumn(name = "task_id"))
    private List<String> photonames = new ArrayList<>();

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    public Task() {
    }

    public Task(String taskname, String product, String description, String address, User user) {
        this.taskname = taskname;
        this.product = product;
        this.description = description;
        this.address = address;
        this.user = user;
    }

    public String getUserName(){
        return user!=null ? user.getUsername() : "none";
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

    public List<String> getPhotonames() {
        return photonames;
    }

    public void setPhotonames(List<String> photonames) {
        this.photonames = photonames;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
