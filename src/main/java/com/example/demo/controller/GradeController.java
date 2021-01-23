package com.example.demo.controller;

import com.example.demo.entity.Grade;
import com.example.demo.service.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GradeController {

    @Autowired
    private GradeService gradeService;

    @PostMapping("/grade/post")
    public Grade createGrade(@RequestBody Grade grade){
        return gradeService.createGrade(grade);
    }

    @GetMapping("/grade/get/all")
    public List<Grade> getAllGrade(){
        return  gradeService.getAllGrade();
    }

}
