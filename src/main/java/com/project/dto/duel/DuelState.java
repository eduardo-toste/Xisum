package com.project.dto.duel;

import com.project.dto.PlayerView;
import com.project.dto.question.QuestionView;
import com.project.model.Room;
import com.project.model.enums.RoomStatus;

import java.util.List;

public record DuelState(
        String roomCode,
        RoomStatus status,
        List<PlayerView> players,
        QuestionView currentQuestion,
        boolean finished
) {
    public static DuelState from(Room room, QuestionView currentQuestion) {
        List<PlayerView> players = room.getPlayers().stream()
                .map(PlayerView::from)
                .toList();

        return new DuelState(
                room.getCode(),
                room.getStatus(),
                players,
                currentQuestion,
                room.getStatus() == RoomStatus.FINISHED
        );
    }
}