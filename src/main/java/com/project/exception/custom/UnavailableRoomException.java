package com.project.exception.custom;

public class UnavailableRoomException extends RuntimeException {

    public UnavailableRoomException() {
        super("This room is not available");
    }

}
