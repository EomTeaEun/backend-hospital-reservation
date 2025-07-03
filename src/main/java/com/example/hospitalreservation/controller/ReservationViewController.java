package com.example.hospitalreservation.controller;

import com.example.hospitalreservation.service.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/reservations")
@RequiredArgsConstructor
public class ReservationViewController {

    private final ReservationService reservationService;

    @GetMapping
    public String list(Model model) {
        model.addAttribute("reservations",
                reservationService.getAllReservations());
        return "index";           // templates/index.html
    }

    @GetMapping("/new")
    public String form() {
        return "reservation_form"; // templates/reservation_form.html
    }
}
