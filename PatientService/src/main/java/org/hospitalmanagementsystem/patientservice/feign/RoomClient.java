package org.hospitalmanagementsystem.patientservice.feign;

import org.hospitalmanagementsystem.patientservice.dto.RoomResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name="ROOMSERVICE")
public interface RoomClient {

    @GetMapping("/rooms/allocate")
    RoomResponseDTO allocateRoom();
}