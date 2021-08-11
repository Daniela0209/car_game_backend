package com.gamecar.gamecar.domain;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Player {

    @Id
    private String playerId;
    private String namePlayer;


    public String getPlayerId() {
        return playerId;
    }

    public void setPlayerId(String playerId) {
        this.playerId = playerId;
    }

    public String getNamePlayer() {
        return namePlayer;
    }


    public void setNamePlayer(String namePlayer) {
        this.namePlayer = namePlayer;
    }


}
