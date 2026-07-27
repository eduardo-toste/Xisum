package com.project.exception.custom;

public class DuelNotStartedException extends BusinessException {

    public DuelNotStartedException() {
        super("This duel is not started yet");
    }

}
