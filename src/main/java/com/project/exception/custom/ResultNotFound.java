package com.project.exception.custom;

public class ResultNotFound extends NotFoundException {

    public ResultNotFound() {
        super("Result not found for this room");
    }

}
