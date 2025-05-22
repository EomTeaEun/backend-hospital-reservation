package com.example.hospitalreservation.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime reservationTime;
    private LocalDateTime reservationEndTime;
    private String reason;

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    protected Reservation() {}

    public Reservation(Doctor doctor, Patient patient, LocalDateTime start, LocalDateTime end, String reason) {
        this.doctor = doctor;
        this.patient = patient;
        this.reservationTime = start;
        this.reservationEndTime = end;
        this.reason = reason;
    }
}
