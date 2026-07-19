package com.project.service;

import com.project.util.RoomCodeGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoomService {

    private final RoomCodeGenerator roomCodeGenerator;
    private final RedisService redisService;



}
