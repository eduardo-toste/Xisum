package com.project.service;

import com.project.dto.CreateQuestionsRequest;
import com.project.mapper.QuestionMapper;
import com.project.model.Topic;
import com.project.repository.QuestionRepository;
import com.project.repository.TopicRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class QuestionService {

    private final QuestionRepository questionRepository;
    private final TopicRepository topicRepository;
    private final QuestionMapper questionMapper;

    public void createQuestions(CreateQuestionsRequest request) {
        Topic topic = findOrCreateTopic(request);
        questionRepository.saveAll(questionMapper.toQuestionList(request.questions(), topic));
    }

    private Topic findOrCreateTopic(CreateQuestionsRequest request) {
        Topic newTopic = new Topic(
                null,
                request.topicName(),
                request.topicSchoolYear(),
                request.topicSubject(),
                new ArrayList<>());

        return topicRepository.findByName(request.topicName())
                .orElseGet(() -> topicRepository.save(newTopic));
    }

}
