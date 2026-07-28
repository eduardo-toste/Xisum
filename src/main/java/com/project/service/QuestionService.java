package com.project.service;

import com.project.dto.question.CreateQuestionsRequest;
import com.project.exception.custom.QuestionNotFoundException;
import com.project.mapper.QuestionMapper;
import com.project.model.Question;
import com.project.model.Topic;
import com.project.repository.QuestionRepository;
import com.project.repository.TopicRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class QuestionService {

    private final QuestionRepository questionRepository;
    private final TopicService topicService;
    private final QuestionMapper questionMapper;

    public void createQuestions(CreateQuestionsRequest request) {
        Topic topic = topicService.findOrCreateTopic(request);
        questionRepository.saveAll(questionMapper.toQuestionList(request.questions(), topic));
    }

    public Question getQuestion(UUID questionId) {
        return questionRepository.findById(questionId)
                .orElseThrow(QuestionNotFoundException::new);
    }

}
