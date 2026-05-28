package org.hospitalmanagementsystem.doctorservice.service;

import org.hospitalmanagementsystem.doctorservice.model.Doctor;
import org.hospitalmanagementsystem.doctorservice.repository.DoctorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepo doctorRepo;

    public Doctor getDoctor(String name){
        return doctorRepo.findByName(name);
    }
}
