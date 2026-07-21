package com.project.controller;

import com.project.dto.CreateRoomRequest;
import com.project.dto.JoinRoomRequest;
import com.project.dto.JoinRoomResponse;
import com.project.dto.CreateRoomResponse;
import com.project.service.RoomService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rooms")
@RequiredArgsConstructor
public class RoomController {

    private final RoomService roomService;

    @PostMapping
    public ResponseEntity<CreateRoomResponse> createRoom(@RequestBody @Valid CreateRoomRequest request) {
        CreateRoomResponse response = roomService.createRoom(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PostMapping("/join")
    public ResponseEntity<JoinRoomResponse> joinRoom(@RequestBody @Valid JoinRoomRequest request) {
        JoinRoomResponse response = roomService.joinRoom(request);
        return ResponseEntity.ok(response);
    }

}
