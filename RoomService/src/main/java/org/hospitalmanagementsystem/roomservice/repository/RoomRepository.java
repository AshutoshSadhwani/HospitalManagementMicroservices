package org.hospitalmanagementsystem.roomservice.repository;

import org.hospitalmanagementsystem.roomservice.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room,Long> {

    Room findFirstByOccupiedFalse();

    Room findByRoomNo(Integer roomNo);
}
