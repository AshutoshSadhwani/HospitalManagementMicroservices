package org.hospitalmanagementsystem.patientservice.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int age;
    private String disease;
    private String patientType;
    private double bill;
    // FROM DOCTOR SERVICE
    private String doctorName;

    // FROM ROOM SERVICE
    private Integer roomNo;
}