package com.example.hospital.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Data
@NoArgsConstructor

@Table(name = "appointment")
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "appointment_type")
    private String appointmentName;

    @Column(name = "appointment_time")
    private Long appointmentTime;

    @Column(name = "is_active")
    private int isActive;

    @Column(name = "is_deleted")
    private int isDeleted;

    @Column(name = "created_at")
    private Timestamp createdAt;

    @Column(name = "modified_at")
    private Timestamp modifiedAt;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "disease_id",referencedColumnName = "id")
    private Disease disease;

}
