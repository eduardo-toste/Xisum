package com.project.dto.duel;

import com.project.dto.PlayerView;
import com.project.model.Result;

import java.util.List;

public record DuelResultResponse(

        String topicName,
        String roomCode,
        List<PlayerView> players,
        String winner

) {

    public static DuelResultResponse from(Result result) {
        List<PlayerView> players = List.of(
                PlayerView.of(result.getPlayer1Nickname(), result.getPlayer1Score()),
                PlayerView.of(result.getPlayer2Nickname(), result.getPlayer2Score())
        );

        return new DuelResultResponse(
                result.getTopic().getName(),
                result.getRoomCode(),
                players,
                result.getWinner()
        );
    }

}
