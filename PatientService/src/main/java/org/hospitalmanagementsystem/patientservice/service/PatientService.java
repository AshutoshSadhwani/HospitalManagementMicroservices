package org.hospitalmanagementsystem.patientservice.service;

import org.hospitalmanagementsystem.patientservice.dto.DoctorResponseDTO;
import org.hospitalmanagementsystem.patientservice.dto.RoomResponseDTO;
import org.hospitalmanagementsystem.patientservice.feign.BillingClient;
import org.hospitalmanagementsystem.patientservice.feign.DoctorClient;
import org.hospitalmanagementsystem.patientservice.feign.RoomClient;
import org.hospitalmanagementsystem.patientservice.model.Patient;
import org.hospitalmanagementsystem.patientservice.repository.PatientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {

    @Autowired
    private PatientRepo patientRepo;

    @Autowired
    private DoctorClient doctorClient;

    @Autowired
    private RoomClient roomClient;

    @Autowired
    private BillingClient billingClient;

    public List<Patient> getPatients() {

        return patientRepo.findAll();
    }

    public String addPatient(
            Patient patient,
            String doctorName
    ) {

        // DUPLICATE CHECK
        Patient existingPatient = patientRepo.findByName(patient.getName());

        if(existingPatient != null) {

            return "Patient Already Exists";
        }

        // DOCTOR SERVICE CALL
        DoctorResponseDTO doctor =
                doctorClient.getDoctor(doctorName);

        if(doctor == null) {

            return "Doctor Not Found";
        }

        patient.setDoctorName(doctor.getName());

        // ROOM SERVICE
        if(
                patient.getPatientType()
                        .equalsIgnoreCase("IPD")

                        ||

                        patient.getPatientType()
                                .equalsIgnoreCase("ICU")
        ) {

            RoomResponseDTO room =
                    roomClient.allocateRoom();

            patient.setRoomNo(
                    room.getRoomNo()
            );
        }

        // BILLING SERVICE

        Double bill =
                billingClient.getBill(
                        patient.getPatientType()
                );
        patient.setBill(bill);

        patientRepo.save(patient);

        return "Patient Added Successfully";
    }
}