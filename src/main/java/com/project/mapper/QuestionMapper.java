package com.project.mapper;

import com.project.dto.CreateQuestionsRequest;
import com.project.model.Question;
import com.project.model.Topic;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class QuestionMapper {

    public List<Question> toQuestionList(List<CreateQuestionsRequest.QuestionData> questionDataList, Topic topic) {
        return questionDataList.stream()
                .map(questionData -> toQuestion(questionData, topic))
                .toList();
    }

    public Question toQuestion(CreateQuestionsRequest.QuestionData questionData, Topic topic) {
        return new Question(
                null,
                topic,
                questionData.statement(),
                questionData.options(),
                questionData.correctOptionIndex(),
                questionData.difficulty()
        );
    }

}
