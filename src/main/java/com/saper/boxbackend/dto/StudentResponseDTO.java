package com.saper.boxbackend.dto;

import com.saper.boxbackend.model.Student;

public class StudentResponseDTO {

    public Long student_id;

    public  Long client_id;

    public StudentResponseDTO(Student student) {
        this.student_id = student.getId();
        this.client_id = student.getClient().getId();
    }
}
