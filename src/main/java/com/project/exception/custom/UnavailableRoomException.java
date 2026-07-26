package com.project.exception.custom;

public class UnavailableRoomException extends BusinessException {

    public UnavailableRoomException() {
        super("This room is not available");
    }

}
