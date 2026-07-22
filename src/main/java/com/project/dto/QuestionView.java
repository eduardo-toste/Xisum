package com.project.dto;

import com.project.model.Question;

import java.util.List;
import java.util.UUID;

public record QuestionView(

        UUID id,
        String statement,
        List<String> options

) {

    public static QuestionView from(Question question) {
        return new QuestionView(question.getId(), question.getStatement(), question.getOptions());
    }

}
