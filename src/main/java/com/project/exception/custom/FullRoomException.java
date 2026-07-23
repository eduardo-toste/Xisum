package com.project.exception.custom;

public class FullRoomException extends RuntimeException {

    public FullRoomException() {
        super("This room is already full");
    }

}
