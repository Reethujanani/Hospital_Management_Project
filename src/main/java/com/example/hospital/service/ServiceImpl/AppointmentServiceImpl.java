package com.example.hospital.service.ServiceImpl;

import com.example.hospital.dto.AppointmentDTO;
import com.example.hospital.entity.*;
import com.example.hospital.repository.AppointmentRepository;
import com.example.hospital.repository.DiseaseRepository;
import com.example.hospital.repository.DoctorRepository;
import com.example.hospital.repository.PatientRepository;
import com.example.hospital.service.AppointmentService;
import com.sun.istack.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service

public class AppointmentServiceImpl implements AppointmentService {
    private static final Logger LOGGER = null;

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private DiseaseRepository diseaseRepository;

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private PatientRepository patientRepository;

    @Override
    public AppointmentDTO addAppointment(AppointmentDTO appointmentDTO) {
        Appointment appointment = new Appointment();

        try {
            Optional<Disease> disease = diseaseRepository.findById(appointmentDTO.getDiseaseId());
        appointment.setAppointmentName(appointment.getAppointmentName());
        appointment.setAppointmentTime(appointment.getAppointmentTime());
        appointment.setIsActive(appointment.getIsActive());
        appointment.setIsDeleted(appointment.getIsDeleted());
        appointment.setCreatedAt(appointment.getCreatedAt());
        appointment.setModifiedAt(appointment.getModifiedAt());

        appointmentRepository.save(appointment);
        }catch (Exception e){
            e.getMessage();
        }
        return appointmentDTO;
    }

   /* @Override
    public Appointment updateDetails(AppointmentDTO appointment) {
        Appointment appointment1 = new Appointment();
        appointment1.setAppointmentId(appointment.getAppointmentId());
        appointment1.setAppointmentName(appointment.getAppointmentName());
        appointment1.setAppointmentTime(appointment.getAppointmentTime());
        appointment1.setIsActive(appointment.getIsActive());
        appointment1.setIsDeleted(appointment.getIsDeleted());
        appointment1.setCreatedAt(appointment.getCreatedAt());
        appointment1.setModifiedAt(appointment.getModifiedAt());
        appointmentRepository.save(appointment1);
        LOGGER.info("Appointment updated successfully");

        return null;
    }*/

    @Override
    public Page<Appointment> listAllDetails(int pageNo, int pageSize, String sortBy) {
        Pageable pageable = PageRequest.of(pageNo,pageSize, Sort.by(Sort.Direction.DESC,sortBy));
        Page<Appointment> Load = appointmentRepository.findAll(pageable);
        LOGGER.info("Appointment saved successfully");
        return Load;

    }

    @Override
    public Appointment getAppointmentDetailsByID(int id) {
        return appointmentRepository.getById(id);
    }
/*
    @Override
    public Appointment getAppointmentDetailsById(int id) {
        Optional<Appointment> appointment = appointmentRepository.findById(id);
        return appointment.get();

    }*/

    @Override
    public List<Appointment> saveAllDetails(List<Appointment> product) {
        return null;
    }

    @Override
    public String deleteDetailsById(int id) {
         appointmentRepository.deleteById(id);
         return "Deleted successfully";
    }

    @Override
    public Appointment updateDetailsById(AppointmentDTO appointment) {
        Appointment appointment1 = new Appointment();
        appointment1.setAppointmentName(appointment.getAppointmentName());
        appointment1.setAppointmentTime(appointment.getAppointmentTime());
        appointment1.setIsActive(appointment.getIsActive());
        appointment1.setIsDeleted(appointment.getIsDeleted());
        appointment1.setCreatedAt(appointment.getCreatedAt());
        appointment1.setModifiedAt(appointment.getModifiedAt());
        appointmentRepository.save(appointment1);
        LOGGER.info("Appointment updated successfully");
        return null;
    }


}
