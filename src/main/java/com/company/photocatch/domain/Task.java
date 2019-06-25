package com.company.photocatch.domain;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
    private boolean show = true;

    public Task() {
    }

    public Task(String taskname, String product, String description, String address) {
        this.taskname = taskname;
        this.product = product;
        this.description = description;
        this.address = address;

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

    public boolean isShow() {
        return show;
    }

    public void setShow(boolean show) {
        this.show = show;
    }
}
