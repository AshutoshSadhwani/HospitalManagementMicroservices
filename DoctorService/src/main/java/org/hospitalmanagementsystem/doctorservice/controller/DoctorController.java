package org.hospitalmanagementsystem.doctorservice.controller;

import org.hospitalmanagementsystem.doctorservice.model.Doctor;
import org.hospitalmanagementsystem.doctorservice.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/doctor")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;


    @GetMapping("/{name}")
    public Doctor getDoctor(@PathVariable String name){
        return doctorService.getDoctor(name);

    }
}
