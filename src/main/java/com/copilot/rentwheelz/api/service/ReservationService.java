package com.copilot.rentwheelz.api.service;

import com.copilot.rentwheelz.api.dto.StatusOperation;
import com.copilot.rentwheelz.api.entity.Reservation;
import com.copilot.rentwheelz.api.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    public Optional<Reservation> getReservationById(Long id) {
        return reservationRepository.findById(id);
    }

    public Reservation updateReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    // reserve a car
    public StatusOperation reserveCar(Reservation reservation) {
        // Implement reservation logic
        if (reservationRepository.findByBookingId(reservation.getBookingId()) != null) {
            return new StatusOperation("Booking already exists", 0, "Booking already exists", null);
        } else if (!reservationRepository.findByCarID(reservation.getCarID()).isEmpty()) {
            return new StatusOperation("Car already reserved", 0, "Car already reserved", null);
        } else {
            reservation.setStatus("CONFIRMED");
        }
        return new StatusOperation("success", 1, "Your reservation is confirmed", reservationRepository.save(reservation));
    }

    // cancel booking by bookingId
    public StatusOperation cancelBooking(String bookingId) {
        // Implement booking cancellation logic
        Reservation reservation = reservationRepository.findByBookingId(bookingId);
        if (reservation == null) {
            return new StatusOperation("Booking not found", 0, "Booking not found", null);
        } else {
            reservation.setStatus("CANCELLED");
            reservationRepository.save(reservation);
            return new StatusOperation("success", 1,"Your reservation is canceled", reservation);
        }

    }

    // get my bookings by email
    public StatusOperation getMyBookings(String email) {
        // Implement logic to get bookings by email
        List<Reservation> list = reservationRepository.findByUserEmail(email);
        if (list.isEmpty()) {
            return new StatusOperation("Booking not found", 0, "Booking not found", null);
        } else {
            return new StatusOperation("success", list.size(),"Your all Bookings", list);
        }
    }
}