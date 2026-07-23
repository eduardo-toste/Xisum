package com.project.exception.custom;

public class QuestionNotFoundException extends RuntimeException {

    public QuestionNotFoundException() {
        super("Question not found");
    }

}
