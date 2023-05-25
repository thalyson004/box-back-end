package com.saper.boxbackend.controller;

import com.saper.boxbackend.dto.ClientRequestDTO;
import com.saper.boxbackend.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping("/{id}")
    public Object getOne(@PathVariable(name = "id") Long id){
        return studentService.findById(id);
    }

    @PostMapping
    public  Object save(@RequestBody ClientRequestDTO clientRequestDTO){
        return studentService.save(clientRequestDTO);
    }
}
