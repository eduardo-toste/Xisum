package com.project.exception.custom;

public class FullRoomException extends BusinessException {

    public FullRoomException() {
        super("This room is already full");
    }

}
