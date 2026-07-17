package com.project.dto;

import com.project.model.Topic;
import com.project.model.enums.SchoolYear;
import com.project.model.enums.Subject;

import java.util.UUID;

public record TopicResponse(UUID id, String name, SchoolYear schoolYear, Subject subject) {

    public static TopicResponse from(Topic topic) {
        return new TopicResponse(topic.getId(), topic.getName(), topic.getSchoolYear(), topic.getSubject());
    }

}
