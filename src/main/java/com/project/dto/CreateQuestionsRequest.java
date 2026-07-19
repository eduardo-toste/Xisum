package com.project.dto;

import com.project.model.enums.Difficulty;
import com.project.model.enums.SchoolYear;
import com.project.model.enums.Subject;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

import java.util.List;

public record CreateQuestionsRequest(

        @NotBlank(message = "Topic name is required")
        String topicName,

        @NotNull(message = "Topic school year is required")
        SchoolYear topicSchoolYear,

        @NotNull(message = "Topic subject is required")
        Subject topicSubject,

        @NotEmpty(message = "At least one question is required")
        @Valid
        List<QuestionData> questions

) {

    public record QuestionData(

            @NotBlank(message = "Question statement is required")
            String statement,

            @Size(min = 2, message = "At least two options are required")
            List<@NotBlank(message = "Option must not be blank") String> options,

            @PositiveOrZero(message = "Correct option index must be zero or greater")
            int correctOptionIndex,

            @NotNull(message = "Difficulty is required")
            Difficulty difficulty
    ) {
    }

}
