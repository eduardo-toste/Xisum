package com.project.service;

import com.project.dto.TopicResponse;
import com.project.model.Topic;
import com.project.model.enums.SchoolYear;
import com.project.model.enums.Subject;
import com.project.repository.TopicRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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

}
