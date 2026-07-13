package com.project.service;

import com.project.dto.CreateQuestionsRequest;
import com.project.repository.QuestionRepository;
import com.project.repository.TopicRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class QuestionService {

    private final QuestionRepository questionRepository;
    private final TopicRepository topicRepository;

    public void createQuestions(CreateQuestionsRequest request) {
    }

}
