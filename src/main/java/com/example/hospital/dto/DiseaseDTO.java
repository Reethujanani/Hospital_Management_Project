package com.example.hospital.dto;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class DiseaseDTO {

    private Long diseaseId;
    private String diseaseName;
    private int isActive;
    private int isDeleted;
    private Timestamp createdAt;
    private Timestamp modifiedAt;
}
