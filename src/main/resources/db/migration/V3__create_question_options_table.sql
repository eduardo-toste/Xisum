CREATE TABLE question_options (
    question_id UUID NOT NULL REFERENCES questions(id) ON DELETE CASCADE,
    option_index INTEGER NOT NULL,
    option_text VARCHAR(500) NOT NULL,
    PRIMARY KEY (question_id, option_index)
);
