package com.project.service;

import com.project.dto.DuelAnswerRequest;
import com.project.exception.custom.DuelNotStartedException;
import com.project.model.Player;
import com.project.model.Question;
import com.project.model.Room;
import com.project.model.enums.RoomStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DuelService {

    private final RoomService roomService;
    private final RedisService redisService;

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

}
