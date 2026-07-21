package com.project.exception;

public class UnavailableRoomException extends RuntimeException {

    public UnavailableRoomException() {
        super("This room is not available");
    }

}
