package org.hospitalmanagementsystem.patientservice.feign;

import org.hospitalmanagementsystem.patientservice.dto.DoctorResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "DOCTORSERVICE")
public interface DoctorClient {

    @GetMapping("/doctor/{name}")
    DoctorResponseDTO getDoctor(
            @PathVariable String name
    );
}