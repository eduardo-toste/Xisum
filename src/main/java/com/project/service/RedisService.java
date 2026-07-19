package com.project.service;

import com.project.model.Room;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RedisService {

    private static final String ROOM_KEY_PREFIX = "room:";
    private static final Duration TTL = Duration.ofMinutes(30);

    private final RedisTemplate<String, Room> redisTemplate;

    public void saveRoom(Room room) {
        String key = ROOM_KEY_PREFIX + room.getCode();
        redisTemplate.opsForValue().set(key, room, TTL);
    }

    public Optional<Room> findRoomByCode(String code) {
        String key = ROOM_KEY_PREFIX + code;
        Room room = redisTemplate.opsForValue().get(key);
        return Optional.ofNullable(room);
    }

    public void deleteRoom(String code) {
        String key = ROOM_KEY_PREFIX + code;
        redisTemplate.delete(key);
    }

}
