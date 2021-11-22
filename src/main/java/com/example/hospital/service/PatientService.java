package com.example.hospital.service;

import com.example.hospital.dto.PatientDTO;
import com.example.hospital.entity.Patient;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PatientService {

    Page<Patient> listAllDetails(int pageNo , int pageSize, String sortBy);

    Patient getPatientDetailsByID(Long id);

    Patient updatePatientDetails(Patient patient);

    String deleteDetailsById(Long id);

    List<Patient> saveAllDetails(List<Patient> patients);

    PatientDTO addPatient(PatientDTO patient);
}
