package com.example.hospital.dto;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class DoctorDTO {

    private Long doctorId;
    private Long patientId;
    private String doctorName;
    private int isActive;
    private int isDeleted;
    private Timestamp createdAt;
    private Timestamp modifiedAt;

}
