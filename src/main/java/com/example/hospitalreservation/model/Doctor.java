package com.example.hospitalreservation.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    private int startHour;
    private int endHour;

    @OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL)
    private List<Reservation> reservations;

    protected Doctor() {}

    public Doctor(int startHour, int endHour) {
        this.startHour = startHour;
        this.endHour = endHour;
    }

    public String getName() {return name;}

}

