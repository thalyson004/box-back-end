package com.saper.boxbackend.service;

import com.saper.boxbackend.dto.StudentResponseDTO;
import com.saper.boxbackend.model.Student;
import com.saper.boxbackend.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;
    public ResponseEntity<Object> findById(Long id) {
        Optional<Student> studentOptional = studentRepository.findById(id);

        if(studentOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Estudante não encontrado");
        }else{
            return ResponseEntity.status(HttpStatus.OK).body(new StudentResponseDTO(studentOptional.get()));
        }
    }
}
