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

    protected Patient() {}  // JPA 기본 생성자

    public Patient(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // getter, setter 필요 시 추가
}

