package com.saper.boxbackend.controller;

import com.saper.boxbackend.dto.BoxRequestDTO;
import com.saper.boxbackend.service.BoxService;
import org.apache.logging.log4j.spi.ObjectThreadContextMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/box")
public class BoxController {

    @Autowired
    BoxService boxService;

    @GetMapping
    public Object getAll(){
        return boxService.getAll();
    }

    @GetMapping("/{id}")
    public Object getOne(@PathVariable(name = "id") Long id){
        return boxService.findById(id);
    }

    @PostMapping
    public  Object save(@RequestBody BoxRequestDTO boxRequestDTO){return boxService.save(boxRequestDTO);
    }

    @PutMapping("/{id}")
    public  Object update(@PathVariable(name = "id") Long id,
                          @RequestBody BoxRequestDTO boxRequestDTO){
        return boxService.update(id, boxRequestDTO);
    }

    @DeleteMapping("/{id}")
    public Object delete(@PathVariable(name = "id") Long id){
        return boxService.delete(id);
    }
}
