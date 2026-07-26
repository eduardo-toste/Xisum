package com.project.exception.custom;

public class RoomNotFoundException extends NotFoundException {

    public RoomNotFoundException() {
        super("Room not found");
    }

}
