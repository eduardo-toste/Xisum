package com.project.service;

import com.project.dto.duel.DuelAnswerRequest;
import com.project.dto.duel.DuelResultResponse;
import com.project.exception.custom.DuelNotStartedException;
import com.project.model.Player;
import com.project.model.Question;
import com.project.model.Result;
import com.project.model.Room;
import com.project.model.enums.RoomStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DuelService {

    private final RoomService roomService;
    private final RedisService redisService;
    private final ResultService resultService;

    public void answerQuestion(String code, DuelAnswerRequest request) {
        Room room = roomService.findRoomOrThrow(code);

        if (room.getStatus() != RoomStatus.IN_PROGRESS) {
            throw new DuelNotStartedException();
        }

        Player player = room.findPlayerByToken(request.playerToken());

        Question currentQuestion = roomService.getCurrentQuestion(room);

        if (currentQuestion.isCorrectAnswer(request.answer())) {
            player.increaseScore();
            redisService.saveRoom(room);
        }
    }

    public DuelResultResponse getResult(String code) {
        Result result = resultService.getResultByRoom(code);
        return DuelResultResponse.from(result);
    }

}
