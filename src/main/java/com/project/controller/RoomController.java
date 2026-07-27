package com.project.controller;

import com.project.dto.room.*;
import com.project.service.RoomService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

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

    @PostMapping("/{code}/join")
    public ResponseEntity<JoinRoomResponse> joinRoom(@PathVariable String code, @RequestBody @Valid JoinRoomRequest request) {
        JoinRoomResponse response = roomService.joinRoom(code, request);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{code}")
    public ResponseEntity<RoomStateResponse> getRoom(@PathVariable String code) {
        RoomStateResponse response = roomService.getRoom(code);
        return ResponseEntity.ok(response);
    }

}
