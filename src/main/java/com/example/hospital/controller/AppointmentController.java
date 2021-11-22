package com.example.hospital.controller;

import com.example.hospital.dto.AppointmentDTO;
import com.example.hospital.entity.Appointment;
import com.example.hospital.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    //Post Method
    @PostMapping("/post")
    public AppointmentDTO addAppointment(@RequestBody AppointmentDTO appointment){
        return appointmentService.addAppointment(appointment);
    }
    @PostMapping("/createList")
    public List<Appointment> saveAppointment(@RequestBody List<Appointment> Load){
        return appointmentService.saveAllDetails(Load);
    }

    //read method
    @GetMapping("/get")
    public Page<Appointment> listAllDetails(@RequestParam(value = "pageNo",defaultValue = "0") int pageNo,
                                     @RequestParam(value = "pageSize",defaultValue = "10") int pageSize,
                                     @RequestParam(value = "sortBy",defaultValue = "id") String sortBy){
        return appointmentService.listAllDetails(pageNo,pageSize,sortBy);
    }
    //read method by ID
    @GetMapping("/getById/{id}")
    public Appointment getAppointmentDetails(@PathVariable int id){
        return appointmentService.getAppointmentDetailsByID(id);
    }


    @PutMapping("/update")
    public Appointment updateAppointmentDetails(@RequestBody AppointmentDTO appointment) {
        return appointmentService.updateDetailsById(appointment);
    }



    @DeleteMapping("/delete/{id}")
    public String deleteAppointment(@PathVariable int id){
        return appointmentService.deleteDetailsById(id);
    }

}


