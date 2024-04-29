package com.copilot.rentwheelz.api.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;


@Entity
@Table(name = "cars", uniqueConstraints = {
    @UniqueConstraint(columnNames = "carID"),
    @UniqueConstraint(columnNames = "registrationNumber")
})
@Data
@NoArgsConstructor
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(unique = true)
    private String carID;

    @NotNull
    private String carModel;

    @NotNull
    @Column(unique = true)
    private String registrationNumber;

    @NotNull
    private String carAvailability;

    @NotNull
    private String brand;

    @NotNull
    private Double pricePerHour;

    @NotNull
    private String thumbnail;

    @NotNull
    private String carName;

    // getters and setters
}