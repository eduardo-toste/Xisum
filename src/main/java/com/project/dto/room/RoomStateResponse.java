package com.project.dto.room;

import com.project.dto.PlayerView;
import com.project.dto.QuestionView;
import com.project.model.Question;
import com.project.model.Room;
import com.project.model.enums.RoomStatus;

import java.util.List;
import java.util.UUID;

public record RoomStateResponse(

        String code,
        RoomStatus status,
        UUID topicId,
        List<PlayerView> players,
        QuestionView currentQuestion

) {

    public static RoomStateResponse from(Room room, List<PlayerView> players, QuestionView question) {
        return new RoomStateResponse(
                room.getCode(),
                room.getStatus(),
                room.getTopicId(),
                players,
                question
        );
    }

}
