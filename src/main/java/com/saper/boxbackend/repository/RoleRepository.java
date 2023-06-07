package com.saper.boxbackend.repository;

import com.saper.boxbackend.enums.RoleNames;
import com.saper.boxbackend.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    Optional<Role> findByRole(RoleNames roleStudent);
}
