package com.project.dto;

import com.project.model.enums.Difficulty;
import com.project.model.enums.SchoolYear;
import com.project.model.enums.Subject;

import java.util.List;

public record CreateQuestionsRequest(

        String topicName,
        SchoolYear topicSchoolYear,
        Subject topicSubject,
        List<QuestionData> questions

) {

    public record QuestionData(
            String statement,
            List<String> options,
            int correctOptionIndex,
            Difficulty difficulty
    ) {
    }

}
