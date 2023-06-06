package com.saper.boxbackend.config.security;

import com.saper.boxbackend.model.Client;
import com.saper.boxbackend.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthenticatorService implements UserDetailsService {

    @Autowired
    ClientRepository clientRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Client> clientOptional = clientRepository.findByLogin(username);

        if(clientOptional.isEmpty()){
            throw new UsernameNotFoundException("Client não encontrado");
        }else{
            return clientOptional.get();
        }
    }
}
