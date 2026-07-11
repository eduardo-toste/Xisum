CREATE TABLE questions (
    id UUID PRIMARY KEY,
    topic_id UUID NOT NULL REFERENCES topics(id),
    statement TEXT NOT NULL,
    correct_option_index INTEGER NOT NULL,
    difficulty VARCHAR(10) NOT NULL CHECK (difficulty IN ('EASY', 'MEDIUM', 'HARD'))
);

CREATE INDEX idx_questions_topic_id ON questions(topic_id);
