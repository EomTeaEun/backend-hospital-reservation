package com.example.hospitalreservation.controller;

import com.example.hospitalreservation.RequestDTO;
import com.example.hospitalreservation.model.Doctor;
import com.example.hospitalreservation.model.Reservation;
import com.example.hospitalreservation.model.Patient;
import com.example.hospitalreservation.service.ReservationService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.hospitalreservation.service.DoctorService;
import com.example.hospitalreservation.service.PatientService;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

// TODO : 컨트롤러에 필요한 어노테이션을 작성해주세요.
// TODO : 요청 경로는 templates를 참고하여 작성해주세요.

@RestController
@RequestMapping("/api/reservations")
public class ReservationController {
    // TODO : 주입 받아야 할 객체를 설정해주세요. (종속성을 직접 넣어준다...?)
    private final ReservationService reservationService;
    private final DoctorService doctorService;
    private final PatientService patientService;

    public ReservationController(ReservationService reservationService,
                                 DoctorService doctorService,
                                 PatientService patientService) {
        this.reservationService = reservationService;
        this.doctorService = doctorService;
        this.patientService = patientService;
    }

    // TODO : 필요한 어노테이션을 작성해주세요.
    @GetMapping
    public String getReservations(Model model) {
        // TODO : 예약 메인 페이지를 가져오는 코드를 작성해주세요.
        model.addAttribute("reservations", reservationService.getAllReservations());
        return "index";
    }

    // TODO : 필요한 어노테이션을 작성해주세요.
    @GetMapping("/new")
    public String showReservationForm() {
        // TODO : 예약하기 페이지를 가져오는 코드를 작성해주세요.
        return "reservation_form";
    }

    // TODO : 필요한 어노테이션을 작성해주세요.
    @PostMapping
    public Map<String, Object> createReservation(@RequestBody RequestDTO request) {
        Map<String, Object> response = new HashMap<>();

        Doctor doctor  = doctorService.findById(request.getDoctorId())
                .orElseThrow(() -> new IllegalArgumentException("없는 의사"));
        Patient patient = patientService.findById(request.getPatientId())
                .orElseThrow(() -> new IllegalArgumentException("없는 환자"));

        Reservation reservation = request.toReservation(doctor, patient);
        reservationService.createReservation(reservation);

        int fee = reservationService.calculateFee(reservation);

        response.put("reservationId", reservation.getId());
        response.put("message", "예약이 완료되었습니다.");
        response.put("calculatedFee", fee);

        return response;
    }

    // TODO : 필요한 어노테이션을 작성해주세요.
    @DeleteMapping("/delete/{id}")
    public String cancelReservation(@PathVariable Long id, String reason) {
        // TODO : 예약을 취소하는 코드를 작성해주세요.
        reservationService.cancelReservation(id, reason);
        return "redirect:/reservations";
    }

}