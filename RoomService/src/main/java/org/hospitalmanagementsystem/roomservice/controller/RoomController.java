package org.hospitalmanagementsystem.roomservice.controller;

import org.hospitalmanagementsystem.roomservice.model.Room;
import org.hospitalmanagementsystem.roomservice.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rooms")
public class RoomController {

    @Autowired
    private RoomService service;

    @GetMapping("/allocate")
    public Room allocateRoom() {

        return service.allocateRoom();
    }

    @PutMapping("/free/{roomNo}")
    public String freeRoom(
            @PathVariable Integer roomNo
    ) {

        return service.freeRoom(roomNo);
    }
}
