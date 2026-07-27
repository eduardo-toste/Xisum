package com.project.controller;

import com.project.dto.duel.DuelAnswerRequest;
import com.project.dto.duel.DuelResultResponse;
import com.project.service.DuelService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/duels")
public class DuelController {

    private final DuelService duelService;

    @PostMapping("/{code}/answer")
    public ResponseEntity<Void> answerQuestion(@PathVariable String code, @RequestBody @Valid DuelAnswerRequest request) {
        duelService.answerQuestion(code, request);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{code}/result")
    public ResponseEntity<DuelResultResponse> getDuelResult(@PathVariable String code) {
        DuelResultResponse response = duelService.getResult(code);
        return ResponseEntity.ok(response);
    }

}
