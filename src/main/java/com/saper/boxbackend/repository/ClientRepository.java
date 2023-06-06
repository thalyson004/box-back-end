package com.saper.boxbackend.repository;

import com.saper.boxbackend.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

    List<Client> findAllByNameContaining(String name);

    Optional<Client> findByLogin(String username);
}
