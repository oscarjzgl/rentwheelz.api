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
@Table(name = "users", uniqueConstraints = {
    @UniqueConstraint(columnNames = "userName"),
    @UniqueConstraint(columnNames = "userEmail"),
    @UniqueConstraint(columnNames = "proofId")
})
@Data
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(unique = true)
    private String userName;

    @NotNull
    @Column(unique = true)
    private String userEmail;

    @NotNull
    private String userPassword;

    @NotNull
    @Column(unique = true)
    private String proofId;

    // getters and setters
}