package com.example.hospital.entity;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Data
@NoArgsConstructor
@Table(name = "patient")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="patient_name")
    private String patientName;

    @Column(name="contact_number")
    private int contactNumber;

    @Column(name = "is_active")
    private int isActive;

    @Column(name = "is_deleted")
    private int isDeleted;

    @Column(name = "created_at")
    private Timestamp createdAt;

    @Column(name = "modified_at")
    private Timestamp modifiedAt;
}
