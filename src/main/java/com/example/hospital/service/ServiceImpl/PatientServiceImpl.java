package com.example.hospital.service.ServiceImpl;

import com.example.hospital.dto.PatientDTO;
import com.example.hospital.entity.Patient;
import com.example.hospital.repository.PatientRepository;
import com.example.hospital.service.PatientService;
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

public class PatientServiceImpl implements PatientService {

    private static final Logger LOGGER = null;
    @Autowired
    private PatientRepository patientRepository;



    @Override
    public PatientDTO addPatient(PatientDTO patient) {
        Patient patient1 = new Patient();

        patient1.setPatientName(patient.getPatientName());
        patient1.setIsActive(patient.getIsActive());
        patient1.setIsDeleted(patient.getIsDeleted());
        patient1.setCreatedAt(patient.getCreatedAt());
        patient1.setModifiedAt(patient.getModifiedAt());
        try {
            patientRepository.save(patient1);
        }catch (Exception e){
            e.getMessage();
        }
        return null;
    }

    @Override
    public Page<Patient> listAllDetails(int pageNo , int pageSize, String sortBy) {
        Pageable pageable = PageRequest.of(pageNo,pageSize, Sort.by(Sort.Direction.DESC,sortBy));
        Page<Patient> vehicleType = patientRepository.findAll(pageable);
        LOGGER.info("patient saved successfully");
         return vehicleType;
    }

    @Override
    public Patient getPatientDetailsByID(Long id) {
        Optional<Patient> vehicleType = patientRepository.findById(id);
        return vehicleType.get();
    }

    @Override
    public Patient updatePatientDetails(Patient patient) {
        return null;
    }



    @Override
    public String deleteDetailsById(Long id) {
        patientRepository.deleteById(id);
        LOGGER.info("patient deleted successfully");
        return "Success";
    }

    @Override
    public List<Patient> saveAllDetails(List<Patient> patients) {
        return null;
    }


}
