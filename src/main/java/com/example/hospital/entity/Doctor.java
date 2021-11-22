package com.example.hospital.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name = "doctor")
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="doctor_name")
    private String doctorName;

    @Column(name = "is_active")
    private int isActive;

    @Column(name = "is_deleted")
    private int isDeleted;

    @Column(name = "created_at")
    private Timestamp createdAt;

    @Column(name = "modified_at")
    private Timestamp modifiedAt;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "patient_id",referencedColumnName = "id")
    private Patient patient;

    @OneToMany(mappedBy = "doctor")
    private List<PatientDoctor> patientDoctorList;


}
