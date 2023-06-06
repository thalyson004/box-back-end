package com.saper.boxbackend.model;

import com.saper.boxbackend.dto.BoxRequestDTO;
import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Box {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "box_id")
    Long id;

    String name;

    Integer capacity;

    String created_by;

    @OneToMany(mappedBy = "box")
    Set<Team> teams;

    public Box(BoxRequestDTO boxRequestDTO) {
        this.name = boxRequestDTO.name;
        this.capacity = boxRequestDTO.capacity;
        this.created_by = "Admin";
    }

    public Set<Team> getTeams() {
        return teams;
    }

    public void setTeams(Set<Team> teams) {
        this.teams = teams;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public String getCreated_by() {
        return created_by;
    }

    public void setCreated_by(String created_by) {
        this.created_by = created_by;
    }

    public Box() {
    }

    public Box(Long id, String name, Integer capacity, String created_by) {
        this.id = id;
        this.name = name;
        this.capacity = capacity;
        this.created_by = created_by;
    }
}
