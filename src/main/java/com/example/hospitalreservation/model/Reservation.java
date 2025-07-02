package com.example.hospitalreservation.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime startTime;
    private LocalDateTime endTime;
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
        this.startTime = start;
        this.endTime = end;
        this.reason = reason;
    }

    public static Reservation of(Doctor doctor, Patient patient,
                                 LocalDateTime startTime, LocalDateTime endTime, String reason) {
        return new Reservation(doctor, patient, startTime, endTime, reason);
    }

    public Long getId()                 { return id; }
    public Doctor getDoctor()           { return doctor; }
    public Patient getPatient()         { return patient; }
    public LocalDateTime getStartTime() { return startTime; }
    public LocalDateTime getEndTime()   { return endTime; }
    public String getReason()           { return reason; }
}
