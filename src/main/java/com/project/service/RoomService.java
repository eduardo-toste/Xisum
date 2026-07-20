package com.project.service;

import com.project.dto.CreateRoomRequest;
import com.project.dto.JoinRoomRequest;
import com.project.dto.JoinRoomResponse;
import com.project.dto.RoomResponse;
import com.project.exception.RoomNotFoundException;
import com.project.model.Player;
import com.project.model.Room;
import com.project.model.enums.RoomStatus;
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

    @Value("${room.base.link}")
    private String roomBaseLink;

    public RoomResponse createRoom(CreateRoomRequest request) {
        String roomCode = generateUniqueRoomCode();
        Player creator = buildPlayer(request.creatorNickname());
        Room room = buildRoom(roomCode, creator, request.topicId());

        redisService.saveRoom(room);

        return new RoomResponse(roomBaseLink + roomCode, roomCode, creator.getToken());
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

    public JoinRoomResponse joinRoom(JoinRoomRequest request) {
        Room room = redisService.findRoomByCode(request.roomCode())
                .orElseThrow(RoomNotFoundException::new);

        Player player = buildPlayer(request.playerNickname());
        room.addPlayer(player);
        redisService.saveRoom(room);

        return new JoinRoomResponse(player.getToken());
    }

    private Player buildPlayer(String nickname) {
        return Player.builder()
                .token(UUID.randomUUID().toString())
                .nickname(nickname)
                .score(0)
                .build();
    }

    private String generateUniqueRoomCode() {
        String code;

        do {
            code = roomCodeGenerator.generate();
        } while (redisService.findRoomByCode(code).isPresent());

        return code;
    }

}
