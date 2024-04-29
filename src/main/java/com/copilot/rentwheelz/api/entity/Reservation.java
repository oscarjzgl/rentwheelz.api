package com.copilot.rentwheelz.api.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "reservations", uniqueConstraints = {
    @UniqueConstraint(columnNames = "bookingId"),
    @UniqueConstraint(columnNames = "userEmail"),
    @UniqueConstraint(columnNames = "carID")
})
@Data
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(unique = true)
    private String bookingId;

    @NotNull
    @Column(unique = true)
    private String userEmail;

    @NotNull
    @Column(unique = true)
    private String carID;

    @NotNull
    private Date reservationDate;

    @NotNull
    private Date pickupDate;

    @NotNull
    private Date returnDate;

    @NotNull
    private Integer numOfTravellers;

    @NotNull
    private String status;

    @NotNull
    private String car;

    @NotNull
    private String img;

    @NotNull
    private Double total;

    // getters and setters
}