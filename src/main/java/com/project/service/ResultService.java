package com.project.service;

import com.project.exception.custom.ResultNotFound;
import com.project.model.Result;
import com.project.repository.ResultRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ResultService {

    private final ResultRepository resultRepository;

    public Result getResultByRoom(String roomCode) {
        return resultRepository.findByRoomCode(roomCode)
                .orElseThrow(ResultNotFound::new);
    }

}
