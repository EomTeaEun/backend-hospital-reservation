package com.example.hospitalreservation;
import com.example.hospitalreservation.model.Reservation;
import java.time.LocalDateTime;

public class ResponseDTO {
    private final Long reservationId;
    private final String doctorName;
    private final String patientName;
    private final LocalDateTime startTime;
    private final LocalDateTime endTime;
    private final String reason;

    public ResponseDTO(Reservation reservation) {
        this.reservationId = reservation.getId();
        this.doctorName = reservation.getDoctor().getName();
        this.patientName = reservation.getPatient().getName();
        this.startTime = reservation.getStartTime();
        this.endTime = reservation.getEndTime();
        this.reason = reservation.getReason();
    }

}