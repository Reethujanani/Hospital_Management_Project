package com.example.hospital.dto;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class PatientDTO {

    private Long patientId;
    private String patientName;
    private int contactNumber;
    private int isActive;
    private int isDeleted;
    private Timestamp createdAt;
    private Timestamp modifiedAt;
}
