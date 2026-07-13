package com.project.service;

import com.project.model.Room;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RoomService {

    private static final String KEY_PREFIX = "room:";
    private static final Duration TTL = Duration.ofMinutes(30);

    private final RedisTemplate<String, Room> redisTemplate;

    public void save(Room room) {
        String key = KEY_PREFIX + room.getCode();
        redisTemplate.opsForValue().set(key, room, TTL);
    }

    public Optional<Room> findByCode(String code) {
        String key = KEY_PREFIX + code;
        Room room = redisTemplate.opsForValue().get(key);
        return Optional.ofNullable(room);
    }

    public void delete(String code) {
        String key = KEY_PREFIX + code;
        redisTemplate.delete(key);
    }

}
