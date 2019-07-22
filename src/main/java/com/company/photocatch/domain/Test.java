package com.company.photocatch.domain;


import com.company.photocatch.DTO.TestDTO;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

@Entity
public class Test {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_generator")
    @SequenceGenerator(name="seq_generator", sequenceName = "seqTest", initialValue = 1)
    private Long id;

    private String firstname;
    private String oldname;
    private String lastname;


    public Test(Long id, String firstname, String oldname, String lastname) {
        this.id = id;
        this.firstname = firstname;
        this.oldname = oldname;
        this.lastname = lastname;
    }

    public Test(String firstname, String oldname, String lastname) {
        this.firstname = firstname;
        this.oldname = oldname;
        this.lastname = lastname;
    }

    public static Test createTest(TestDTO testDTO){
        return new Test(testDTO.getFirstname(), testDTO.getLastname(), testDTO.getOldname());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getOldname() {
        return oldname;
    }

    public void setOldname(String oldname) {
        this.oldname = oldname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
}
