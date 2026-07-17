package com.project.controller;

import com.project.dto.TopicResponse;
import com.project.model.enums.SchoolYear;
import com.project.model.enums.Subject;
import com.project.service.TopicService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/topics")
@RequiredArgsConstructor
public class TopicController {

    private final TopicService topicService;

    @GetMapping
    public ResponseEntity<List<TopicResponse>> getTopics(@RequestParam SchoolYear schoolYear,
                                                         @RequestParam Subject subject
    ) {
        List<TopicResponse> response = topicService.getTopics(schoolYear, subject);
        return ResponseEntity.ok(response);
    }

}
