package com.saper.boxbackend.service;

import com.saper.boxbackend.dto.ClientRequestDTO;
import com.saper.boxbackend.dto.ClientResponseDTO;
import com.saper.boxbackend.dto.StudentResponseDTO;
import com.saper.boxbackend.model.Client;
import com.saper.boxbackend.model.Student;
import com.saper.boxbackend.repository.ClientRepository;
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

    @Autowired
    ClientRepository clientRepository;

    public ResponseEntity<Object> findById(Long id) {
        Optional<Student> studentOptional = studentRepository.findById(id);

        if(studentOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Estudante não encontrado");
        }else{
            return ResponseEntity.status(HttpStatus.OK).body(new StudentResponseDTO(studentOptional.get()));
        }
    }

    public Object save(ClientRequestDTO clientRequestDTO) {
        Client client = new Client(clientRequestDTO);

        client = clientRepository.save(client);

        Student student = new Student();

        student.setClient(client);

        studentRepository.save(student);

        return ResponseEntity.status(HttpStatus.CREATED).body( new StudentResponseDTO(student) );
    }
}
