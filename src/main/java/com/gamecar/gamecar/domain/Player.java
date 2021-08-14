package com.gamecar.gamecar.domain;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@AllArgsConstructor
@RequiredArgsConstructor
@Document(collection = "Player")
public class Player {

    @Id
    private String playerId;
    private String namePlayer;
    private Integer firstPosition;
    private Integer secondPosition;
    private Integer thirdPosition;

}
