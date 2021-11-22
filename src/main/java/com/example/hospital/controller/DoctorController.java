package com.example.hospital.controller;

import com.example.hospital.dto.DoctorDTO;
import com.example.hospital.entity.Disease;
import com.example.hospital.entity.Doctor;
import com.example.hospital.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctor")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    //Post Method
    @PostMapping("/post")
    public DoctorDTO addDoctor(@RequestBody DoctorDTO Doctor  ){
        return doctorService.addDoctor(Doctor);
    }

    //read method
    @GetMapping("/gets")
    public List<Doctor> getAllDetails(){
        return doctorService.listAllDetails();
    }
    //read method by ID
    @GetMapping("/getById/{id}")
    public Doctor getDetailsByID(@PathVariable Long id){

        return doctorService.getDoctorDetailsByID(id);
    }

    //read method
    @GetMapping("/get")
    public Page<Doctor> getAllDetails(@RequestParam(value = "pageNo",defaultValue = "0") int pageNo,
                                       @RequestParam(value = "pageSize",defaultValue = "10") int pageSize,
                                       @RequestParam(value = "sortBy",defaultValue = "id") String sortBy){
        return doctorService.listAllDetails(pageNo,pageSize,sortBy);
    }

    //update method
    @PutMapping("/update")
    public DoctorDTO updateDoctor(@RequestBody DoctorDTO doctorDTO) {
        return doctorService.updateDoctorDetails(doctorDTO);
    }


    //delete method
    @DeleteMapping("/delete/{id}")
    public String deleteStudent(@PathVariable Long id){
        return doctorService.deleteDetailsById(id);
    }
}


