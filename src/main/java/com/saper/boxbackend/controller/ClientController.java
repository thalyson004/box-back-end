package com.saper.boxbackend.controller;

import com.saper.boxbackend.dto.ClientRequestDTO;
import com.saper.boxbackend.dto.ClientResponseDTO;
import com.saper.boxbackend.model.Client;
import com.saper.boxbackend.repository.ClientRepository;
import com.saper.boxbackend.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    ClientService clientService;

    @GetMapping
    public Object getAll(){
        return clientService.getAll();
    }

    @GetMapping("/{id}")
    public Object getOne(@PathVariable(name = "id") Long id){
        return clientService.findById(id);
    }

    @PostMapping
    public Object save(@RequestBody ClientRequestDTO clientRequestDTO){

        return clientService.save(clientRequestDTO);
    }

    @PutMapping("/{id}")
    public Object update(@PathVariable(name = "id") Long id,
                         @RequestBody ClientRequestDTO clientRequestDTO){
        return clientService.update(id, clientRequestDTO);
    }

    @DeleteMapping("/{id}")
    public Object delete(@PathVariable(name = "id") Long id){
        return clientService.delete(id);
    }
}
