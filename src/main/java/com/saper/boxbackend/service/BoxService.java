package com.saper.boxbackend.service;

import com.saper.boxbackend.dto.BoxRequestDTO;
import com.saper.boxbackend.dto.BoxResponseDTO;
import com.saper.boxbackend.model.Box;
import com.saper.boxbackend.repository.BoxRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
