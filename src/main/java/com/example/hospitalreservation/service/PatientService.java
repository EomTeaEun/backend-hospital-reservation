package com.example.hospitalreservation.service;

import com.example.hospitalreservation.model.Patient;
import com.example.hospitalreservation.repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PatientService {
    private final PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public Optional<Patient> findById(Long id) {
        return patientRepository.findById(id);
    }
}
