package com.project.dto.room;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record CreateRoomRequest(

        @NotNull(message = "Topic ID is required")
        UUID topicId,

        @NotBlank(message = "Creator nickname is required")
        String creatorNickname

) {
}
