package com.gamecar.gamecar.domain;


import com.gamecar.gamecar.values.NamePlayer;
import com.gamecar.gamecar.values.PlayerId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Player {

    @Id
    private PlayerId playerId;
    private NamePlayer namePlayer;

    public PlayerId getPlayerId() {
        return playerId;
    }

    public void setPlayerId(PlayerId playerId) {
        this.playerId = playerId;
    }

    public NamePlayer getNamePlayer() {
        return namePlayer;
    }

    public void setNamePlayer(NamePlayer namePlayer) {
        this.namePlayer = namePlayer;
    }
}
