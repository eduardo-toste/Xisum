package com.project.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record DuelAnswerRequest(

        @NotBlank(message = "Player token is required")
        String playerToken,

        @NotBlank(message = "Answer is required")
        @Size(max = 1, message = "Send only the option value")
        String answer

) {
}
