package com.project.exception.custom;

public class QuestionNotFoundException extends NotFoundException {

    public QuestionNotFoundException() {
        super("Question not found");
    }

}
