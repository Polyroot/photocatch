package com.company.photocatch.controller;


import com.company.photocatch.DTO.TestDTO;
import com.company.photocatch.domain.Task;
import com.company.photocatch.domain.Test;
import com.company.photocatch.repos.TestRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Controller
public class TestController {


    @Autowired
    private TestRepo testRepo;

    @GetMapping("/test")
    public String go(Model model, TestDTO testDTO){

        model.addAttribute("tests", testDTO);
        return "test";
    }


    @PostMapping("/test")
    public String hi(Model model, @ModelAttribute TestDTO testDTO) throws IOException{

        Test.createTest(testDTO);
        model.addAttribute("tests", testDTO);
        return "test";
    }
}
