package com.example.hospital.service;

import com.example.hospital.dto.DoctorDTO;
import com.example.hospital.entity.Doctor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DoctorService {

    Page<Doctor> listAllDetails(int pageNo, int pageSize, String sortBy);

    List<Doctor> listAllDetails();

    Doctor getDoctorDetailsByID(Long id);

    String deleteDetailsById(Long id);

     DoctorDTO addDoctor(DoctorDTO doctorDTO);

     DoctorDTO updateDoctorDetails(DoctorDTO doctorDTO);
}
