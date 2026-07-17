package com.project.repository;

import com.project.model.Topic;
import com.project.model.enums.SchoolYear;
import com.project.model.enums.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TopicRepository extends JpaRepository<Topic, UUID> {

    Optional<Topic> findByName(String topicName);

    List<Topic> findBySchoolYearAndSubject(SchoolYear schoolYear, Subject subject);

}
