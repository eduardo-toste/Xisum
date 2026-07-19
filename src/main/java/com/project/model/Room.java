package com.project.model;

import com.project.model.enums.RoomStatus;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class Room {

    private String code;
    private UUID topicId;
    private List<UUID> questionIds;
    private Integer currentQuestionIndex;
    private List<Player> players;
    private RoomStatus status;
    private Instant createdAt;

}
