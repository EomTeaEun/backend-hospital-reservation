package com.example.hospitalreservation.service;

import com.example.hospitalreservation.model.Doctor;
import com.example.hospitalreservation.repository.DoctorRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DoctorService {
    private final DoctorRepository doctorRepository;

    public DoctorService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    public Optional<Doctor> findById(Long id) {
        return doctorRepository.findById(id);
    }
}