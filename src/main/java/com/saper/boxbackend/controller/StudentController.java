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

    @PostMapping("/{student_id}/{team_id}")
    public Object enroll(
            @PathVariable(name = "student_id") Long student_id,
            @PathVariable(name = "team_id") Long team_id){
        return  studentService.enroll(student_id, team_id);
    }
}
