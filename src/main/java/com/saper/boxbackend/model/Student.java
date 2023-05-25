package com.saper.boxbackend.model;

import jakarta.persistence.*;

@Entity
public class Student {

    @Id
    @Column(name = "student_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @OneToOne
    @JoinColumn(name = "client_id")
    Client client;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Student() {
    }

    public Student(Long id, Client client) {
        this.id = id;
        this.client = client;
    }
}
