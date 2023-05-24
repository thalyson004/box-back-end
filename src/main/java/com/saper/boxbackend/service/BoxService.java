package com.saper.boxbackend.service;

import com.saper.boxbackend.dto.BoxRequestDTO;
import com.saper.boxbackend.dto.BoxResponseDTO;
import com.saper.boxbackend.model.Box;
import com.saper.boxbackend.repository.BoxRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BoxService {

    @Autowired
    BoxRepository boxRepository;
    public Object getAll() {
        return boxRepository.findAll().stream().map((box)-> new BoxResponseDTO(box));
    }

    public Object save(BoxRequestDTO boxRequestDTO) {
        Box box = new Box(boxRequestDTO);

        return new BoxResponseDTO(boxRepository.save(box));
    }

    public ResponseEntity<Object> findById(Long id) {
        Optional<Box> optionalBox = boxRepository.findById(id);

        if(optionalBox.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Box não encontrado");
        }else{
            return ResponseEntity.status(HttpStatus.OK).body(optionalBox.get());
        }
    }
}
