CREATE TABLE results (
    id UUID PRIMARY KEY,
    topic_id UUID NOT NULL REFERENCES topics(id),
    room_code VARCHAR(20) NOT NULL,
    player1_nickname VARCHAR(100) NOT NULL,
    player2_nickname VARCHAR(100) NOT NULL,
    player1_score INTEGER NOT NULL,
    player2_score INTEGER NOT NULL,
    winner VARCHAR(100),
    created_at TIMESTAMPTZ NOT NULL
);

CREATE INDEX idx_results_topic_id ON results(topic_id);
CREATE INDEX idx_results_room_code ON results(room_code);
