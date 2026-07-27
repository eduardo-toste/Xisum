package com.project.dto;

import jakarta.validation.constraints.NotBlank;

public record DuelAnswerRequest(

        @NotBlank(message = "Player token is required")
        String playerToken,

        @NotBlank(message = "Answer is required")
        String answer

) {
}
