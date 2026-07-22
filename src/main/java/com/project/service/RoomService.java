package com.project.service;

import com.project.dto.PlayerView;
import com.project.dto.QuestionView;
import com.project.dto.room.*;
import com.project.exception.RoomNotFoundException;
import com.project.model.Player;
import com.project.model.Question;
import com.project.model.Room;
import com.project.model.enums.RoomStatus;
import com.project.repository.QuestionRepository;
import com.project.util.RoomCodeGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RoomService {

    private final RoomCodeGenerator roomCodeGenerator;
    private final RedisService redisService;
    private final QuestionService questionService;

    @Value("${room.base.link}")
    private String roomBaseLink;

    public CreateRoomResponse createRoom(CreateRoomRequest request) {
        String roomCode = generateUniqueRoomCode();
        Player creator = buildPlayer(request.creatorNickname());
        Room room = buildRoom(roomCode, creator, request.topicId());

        redisService.saveRoom(room);

        return new CreateRoomResponse(roomBaseLink + roomCode, roomCode, creator.getToken());
    }

    public JoinRoomResponse joinRoom(JoinRoomRequest request) {
        Room room = findRoomOrThrow(request.roomCode());

        Player player = buildPlayer(request.playerNickname());
        room.addPlayer(player);
        redisService.saveRoom(room);

        return new JoinRoomResponse(player.getToken());
    }

    public RoomStateResponse getRoom(String code) {
        Room room = findRoomOrThrow(code);

        List<PlayerView> players = room.getPlayers()
                .stream()
                .map(PlayerView::from)
                .toList();

        QuestionView currentQuestion = room.getStatus() == RoomStatus.IN_PROGRESS
                ? QuestionView.from(getCurrentQuestion(room))
                : null;

        return RoomStateResponse.from(room, players, currentQuestion);
    }

    private Question getCurrentQuestion(Room room) {
        UUID currentQuestionId = room.getQuestionIds().get(room.getCurrentQuestionIndex());
        return questionService.getQuestion(currentQuestionId);
    }

    private Player buildPlayer(String nickname) {
        return Player.builder()
                .token(UUID.randomUUID().toString())
                .nickname(nickname)
                .score(0)
                .build();
    }

    private Room buildRoom(String roomCode, Player creator, UUID topicId) {
        return Room.builder()
                .code(roomCode)
                .topicId(topicId)
                .questionIds(List.of())
                .currentQuestionIndex(null)
                .players(new ArrayList<>(List.of(creator)))
                .status(RoomStatus.WAITING)
                .createdAt(Instant.now())
                .build();
    }

    private String generateUniqueRoomCode() {
        String code;

        do {
            code = roomCodeGenerator.generate();
        } while (redisService.findRoomByCode(code).isPresent());

        return code;
    }

    private Room findRoomOrThrow(String roomCode) {
        return redisService.findRoomByCode(roomCode)
                .orElseThrow(RoomNotFoundException::new);
    }

}
