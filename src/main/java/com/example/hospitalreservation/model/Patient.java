package com.example.hospitalreservation.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int age;

    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL)
    private List<Reservation> reservations;

    protected Patient() {}

    public Patient(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() { return name; }

}

