package org.hospitalmanagementsystem.doctorservice.repository;

import org.hospitalmanagementsystem.doctorservice.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepo extends JpaRepository<Doctor,Long> {

    Doctor findByName(String name);
}
