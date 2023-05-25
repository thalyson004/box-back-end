package com.saper.boxbackend.controller;

import com.saper.boxbackend.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping("/{id}")
    public Object getOne(@PathVariable(name = "id") Long id){
        return studentService.findById(id);
    }
}
