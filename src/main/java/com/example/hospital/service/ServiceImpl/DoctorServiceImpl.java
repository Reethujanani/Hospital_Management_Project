package com.example.hospital.service.ServiceImpl;

import com.example.hospital.dto.DoctorDTO;
import com.example.hospital.entity.Doctor;
import com.example.hospital.entity.Patient;
import com.example.hospital.repository.DoctorRepository;
import com.example.hospital.repository.PatientRepository;
import com.example.hospital.service.DoctorService;

import com.sun.istack.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class DoctorServiceImpl implements DoctorService {

    private static final Logger LOGGER = null;
    @Autowired
    private DoctorRepository doctorrepository;

    @Autowired
    private PatientRepository patientRepository;

    @Override
    public DoctorDTO addDoctor(DoctorDTO doctorDTO) {

        Doctor doctor = new Doctor();

        try {
            Optional<Patient> patient = patientRepository.findById(doctorDTO.getPatientId());
            doctor.setPatient(patient.get());
        doctor.setDoctorName(doctorDTO.getDoctorName());
        doctor.setIsActive(doctorDTO.getIsActive());
        doctor.setIsDeleted(doctorDTO.getIsDeleted());
        doctor.setCreatedAt(doctorDTO.getCreatedAt());
        doctor.setModifiedAt(doctorDTO.getModifiedAt());
            doctorrepository.save(doctor);
        }catch (Exception e){
            e.getMessage();
        }
        return doctorDTO;
    }



    @Override
    public DoctorDTO updateDoctorDetails(DoctorDTO doctorDTO) {

        Doctor doctor1 = new Doctor();
        doctor1.setDoctorName(doctorDTO.getDoctorName());
        doctor1.setIsActive(doctorDTO.getIsActive());
        doctor1.setIsDeleted(doctorDTO.getIsDeleted());
        doctor1.setCreatedAt(doctorDTO.getCreatedAt());
        doctor1.setModifiedAt(doctorDTO.getModifiedAt());
        LOGGER.info("doctor updated successfully");
        return null;
    }




    @Override
    public Page<Doctor> listAllDetails(int pageNo , int pageSize, String sortBy) {
        Pageable pageable = PageRequest.of(pageNo,pageSize, Sort.by(Sort.Direction.DESC,sortBy));
        Page<Doctor> Doctor = doctorrepository.findAll(pageable);
        LOGGER.info("doctor saved successfully");
        return Doctor;
    }

    @Override
    public List<Doctor> listAllDetails() {
        return null;
    }

    @Override
    public Doctor getDoctorDetailsByID(Long id) {
        Optional<Doctor> doctor = doctorrepository.findById(id);
        return doctor.get();
    }


    @Override
    public String deleteDetailsById(Long id) {
        doctorrepository.deleteById(id);
         return "Successfully deleted";
    }


}
