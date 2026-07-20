package com.project.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Player {

    private String nickname;
    private String token;
    private Integer score;


}
