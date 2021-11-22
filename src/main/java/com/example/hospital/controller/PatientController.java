package com.example.hospital.controller;

import com.example.hospital.dto.PatientDTO;
import com.example.hospital.entity.Patient;
import com.example.hospital.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PatientController {

    @Autowired
    private PatientService patientService;
    private Object Patient;

    //Post Method
    @PostMapping("/patient/post")
    public PatientDTO addVehicleType(@RequestBody PatientDTO Patient){
        return patientService.addPatient(Patient);
    }
    @PostMapping("/patient/createList")
    public List<Patient> savePatient(@RequestBody List<Patient> Patient){
        return patientService.saveAllDetails(Patient);
    }

    //read method by ID
    @GetMapping("/patient/getById")
    public Patient getDetailsByID(@RequestParam Long id){

        return patientService.getPatientDetailsByID(id);
    }
    //read method
    @GetMapping("/patient/get")
    public Page<Patient> getAllDetails(@RequestParam(value = "pageNo",defaultValue = "0") int pageNo,
                                           @RequestParam(value = "pageSize",defaultValue = "10") int pageSize,
                                           @RequestParam(value = "sortBy",defaultValue = "id") String sortBy){
        return patientService.listAllDetails(pageNo,pageSize,sortBy);
    }

    //update method
    @PutMapping("/patient/update")
    public Patient updatePatient(@RequestBody Patient Patient) {
        return patientService.updatePatientDetails(Patient);
    }


    //delete method+
    @DeleteMapping("/delete/{id}")
    public String deletePatient(@PathVariable Long id){
        return patientService.deleteDetailsById(id);
    }
}

