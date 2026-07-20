package com.project.exception;

public class InvalidTokenException extends RuntimeException {

    public InvalidTokenException() {
        super("This player token is not valid for the room");
    }

}
