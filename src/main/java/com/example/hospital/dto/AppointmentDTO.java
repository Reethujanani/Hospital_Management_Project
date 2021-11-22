package com.example.hospital.dto;

import lombok.Data;

import java.sql.Timestamp;

@Data

public class AppointmentDTO {

    private Long appointmentId;
    private Long diseaseId;
    private String appointmentName;
    private Long appointmentTime;
    private int isActive;
    private int isDeleted;
    private Timestamp createdAt;
    private Timestamp modifiedAt;
}
