package org.hospitalmanagementsystem.roomservice.service;


import org.hospitalmanagementsystem.roomservice.model.Room;
import org.hospitalmanagementsystem.roomservice.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoomService {
    @Autowired
    private RoomRepository roomRepository;

    public Room allocateRoom() {

        Room room = roomRepository.findFirstByOccupiedFalse();

        if(room == null) {
            throw new RuntimeException("No Rooms Available");
        }

        room.setOccupied(true);

        return roomRepository.save(room);
    }

    public String freeRoom(Integer roomNo) {

        Room room = roomRepository.findByRoomNo(roomNo);

        if(room == null) {
            return "Room Not Found";
        }

        room.setOccupied(false);

        roomRepository.save(room);

        return "Room Freed";
    }
}
