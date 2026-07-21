package com.project.dto.room;

import jakarta.validation.constraints.NotBlank;

public record JoinRoomRequest(

        @NotBlank(message = "Room code is required")
        String roomCode,

        @NotBlank(message = "Nickname is required")
        String playerNickname

) {
}
