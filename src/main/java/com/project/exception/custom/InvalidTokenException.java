package com.project.exception.custom;

public class InvalidTokenException extends RuntimeException {

    public InvalidTokenException() {
        super("This player token is not valid for the room");
    }

}
