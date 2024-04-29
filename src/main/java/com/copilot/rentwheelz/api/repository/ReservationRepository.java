package com.copilot.rentwheelz.api.repository;

import com.copilot.rentwheelz.api.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    Reservation findByBookingId(String bookingId);
    List<Reservation> findByUserEmail(String email);

    List<Reservation> findByCarID(String carID);
}