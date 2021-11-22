package com.example.hospital.service;

import com.example.hospital.dto.AppointmentDTO;
import com.example.hospital.entity.Appointment;
import org.springframework.data.domain.Page;

import java.util.List;

public interface AppointmentService {


    AppointmentDTO addAppointment(AppointmentDTO appointment);

    Page<Appointment> listAllDetails(int pageNo , int pageSize, String sortBy);

    Appointment getAppointmentDetailsByID(int id);

    List<Appointment> saveAllDetails(List<Appointment> product);

    String deleteDetailsById(int id);

    Appointment updateDetailsById(AppointmentDTO appointment);


}
    