package com.saper.boxbackend.repository;

import com.saper.boxbackend.model.Box;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoxRepository extends JpaRepository<Box, Long> {
}
