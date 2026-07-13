package com.project.controller;

import com.project.dto.CreateQuestionsRequest;
import com.project.service.QuestionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admin/questions")
public class QuestionController {

    private final QuestionService questionService;

    @PostMapping("/bulk")
    public ResponseEntity<Void> createQuestions(@RequestBody @Valid CreateQuestionsRequest request) {
        questionService.createQuestions(request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
