package com.saper.boxbackend.controller;

import com.saper.boxbackend.dto.ClientRequestDTO;
import com.saper.boxbackend.dto.ClientResponseDTO;
import com.saper.boxbackend.model.Client;
import com.saper.boxbackend.repository.ClientRepository;
import com.saper.boxbackend.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    ClientService clientService;

    @GetMapping
    public Object getAllByName(@RequestParam(name = "name", defaultValue = "") String name){
        return clientService.getAllByName(name);
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

    @GetMapping("/username")
    public Object getUsername(){
        Object logged = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        String username = "";

        if (logged instanceof Client) {
            username = ((Client) logged).getUsername();
        }
        return username;
    }
}
