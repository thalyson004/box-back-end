package com.saper.boxbackend.model;

import jakarta.persistence.*;

@Entity
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String schedule; //35_19

    @ManyToOne
    @JoinColumn(name = "box_id")
    Box box;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    public Box getBox() {
        return box;
    }

    public void setBox(Box box) {
        this.box = box;
    }

    public Team() {
    }

    public Team(Long id, String schedule, Box box) {
        this.id = id;
        this.schedule = schedule;
        this.box = box;
    }
}
