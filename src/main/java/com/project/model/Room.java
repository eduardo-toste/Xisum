package com.project.model;

import com.project.exception.FullRoomException;
import com.project.exception.InvalidTokenException;
import com.project.model.enums.RoomStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Room {

    private String code;
    private UUID topicId;
    private List<UUID> questionIds;
    private Integer currentQuestionIndex;
    private List<Player> players;
    private RoomStatus status;
    private Instant createdAt;

    private boolean isFull() {
        return players.size() >= 2;
    }

    public void addPlayer(Player player) {
        if (isFull()) throw new FullRoomException();
        players.add(player);
    }

    public Player findPlayerByToken(String token) {
        return players.stream()
                .filter(player -> player.getToken().equals(token))
                .findFirst()
                .orElseThrow(InvalidTokenException::new);
    }

}
