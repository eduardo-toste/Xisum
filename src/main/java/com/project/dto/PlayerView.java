package com.project.dto;

import com.project.model.Player;
import com.project.model.Question;

public record PlayerView(

        String nickname,
        Integer score

) {

    public static PlayerView from(Player player) {
        return new PlayerView(player.getNickname(), player.getScore());
    }

}
