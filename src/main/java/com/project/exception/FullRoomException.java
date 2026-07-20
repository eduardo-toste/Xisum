package com.project.exception;

public class FullRoomException extends RuntimeException {

    public FullRoomException() {
        super("This room is already full");
    }

}
