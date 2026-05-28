package org.hospitalmanagementsystem.patientservice.controller;

import org.hospitalmanagementsystem.patientservice.model.Patient;
import org.hospitalmanagementsystem.patientservice.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/patients")
public class PatientController {
    @Autowired
    private PatientService service;

    @PostMapping("/add")
    public String addPatient(

            @RequestBody Patient patient,

            @RequestParam String doctorName) {

        return service.addPatient(
                patient,
                doctorName
        );
    }
}
