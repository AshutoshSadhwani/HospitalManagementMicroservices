package org.hospitalmanagementsystem.patientservice.dto;

public class RoomResponseDTO {

    private Integer roomNo;

    private boolean occupied;

    // GETTERS AND SETTERS

    public Integer getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(Integer roomNo) {
        this.roomNo = roomNo;
    }

    public boolean isOccupied() {
        return occupied;
    }

    public void setOccupied(boolean occupied) {
        this.occupied = occupied;
    }
}
