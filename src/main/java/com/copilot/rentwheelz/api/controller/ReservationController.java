package com.copilot.rentwheelz.api.controller;

import com.copilot.rentwheelz.api.dto.StatusOperation;
import com.copilot.rentwheelz.api.entity.Reservation;
import com.copilot.rentwheelz.api.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reservations")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @GetMapping("/all")
    public ResponseEntity<List<Reservation>> getAllReservations() {
        return ResponseEntity.ok(reservationService.getAllReservations());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reservation> getReservationById(@PathVariable Long id) {
        return ResponseEntity.of(reservationService.getReservationById(id));
    }

    @PutMapping
    public ResponseEntity<Reservation> updateReservation(@RequestBody Reservation reservation) {
        return ResponseEntity.ok(reservationService.updateReservation(reservation));
    }
    // reserve car
    @PostMapping("/reserve")
    public ResponseEntity<StatusOperation> reserveCar(@RequestBody Reservation reservation) {
        return ResponseEntity.ok(reservationService.reserveCar(reservation));
    }

    // get my bookings by email
    @GetMapping("/mybookings/{email}")
    public ResponseEntity<StatusOperation> getMyBookings(@PathVariable String email) {
        return ResponseEntity.ok(reservationService.getMyBookings(email));
    }

    // cancel booking by bookingId
    @PutMapping("/cancel/{bookingId}")
    public ResponseEntity<StatusOperation> cancelBooking(@PathVariable String bookingId) {
        reservationService.cancelBooking(bookingId);
        return ResponseEntity.ok(reservationService.cancelBooking(bookingId));
    }
}