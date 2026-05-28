package org.hospitalmanagementsystem.patientservice.repository;



import org.hospitalmanagementsystem.patientservice.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepo
        extends JpaRepository<Patient, Long> {

    Patient findByName(String name);
}
