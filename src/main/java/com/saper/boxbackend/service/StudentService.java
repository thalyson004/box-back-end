package com.saper.boxbackend.service;

import com.saper.boxbackend.dto.ClientRequestDTO;
import com.saper.boxbackend.dto.ClientResponseDTO;
import com.saper.boxbackend.dto.StudentResponseDTO;
import com.saper.boxbackend.enums.RoleNames;
import com.saper.boxbackend.model.Client;
import com.saper.boxbackend.model.Role;
import com.saper.boxbackend.model.Student;
import com.saper.boxbackend.model.Team;
import com.saper.boxbackend.repository.ClientRepository;
import com.saper.boxbackend.repository.RoleRepository;
import com.saper.boxbackend.repository.StudentRepository;
import com.saper.boxbackend.repository.TeamRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    TeamRepository teamRepository;

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    RoleRepository roleRepository;

    public ResponseEntity<Object> findById(Long id) {
        Optional<Student> studentOptional = studentRepository.findById(id);

        if(studentOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Estudante não encontrado");
        }else{
            return ResponseEntity.status(HttpStatus.OK).body(new StudentResponseDTO(studentOptional.get()));
        }
    }

    @Transactional
    public Object save(ClientRequestDTO clientRequestDTO) {
        Client client = new Client(clientRequestDTO);

        setRoleAsStudent(client);

        client = clientRepository.save(client);

        Student student = new Student();

        student.setClient(client);

        studentRepository.save(student);

        return ResponseEntity.status(HttpStatus.CREATED).body( new StudentResponseDTO(student) );
    }

    public ResponseEntity<Object> enroll(Long student_id, Long team_id) {
        Optional<Team> optionalTeam = teamRepository.findById(team_id);

        if(optionalTeam.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Time não encontrado");
        }

        Optional<Student> optionalStudent = studentRepository.findById(student_id);

        if(optionalStudent.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Estudante não encontrado");
        }

        Team team = optionalTeam.get();
        Student student = optionalStudent.get();

        if(team.getStudents().contains(student)){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Estudante já matriculado");
        }

        team.getStudents().add(student);

        teamRepository.save(team);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    public void setRoleAsStudent(Client client){
        Optional<Role> optionalRole =
                roleRepository.findByRole(RoleNames.ROLE_STUDENT);
        Set<Role> setRole = new HashSet<>();
        setRole.add(optionalRole.get());
        client.setRoles(setRole);
    }

}
