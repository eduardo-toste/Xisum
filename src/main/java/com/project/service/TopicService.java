package com.project.service;

import com.project.dto.TopicResponse;
import com.project.dto.question.CreateQuestionsRequest;
import com.project.model.Topic;
import com.project.model.enums.SchoolYear;
import com.project.model.enums.Subject;
import com.project.repository.TopicRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TopicService {

    private final TopicRepository topicRepository;

    public List<TopicResponse> getTopics(SchoolYear schoolYear, Subject subject) {
        List<Topic> topics = topicRepository.findBySchoolYearAndSubject(schoolYear, subject);
        return topics.stream()
                .map(TopicResponse::from)
                .toList();
    }

    public Topic findOrCreateTopic(CreateQuestionsRequest request) {
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
