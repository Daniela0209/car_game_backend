package com.gamecar.gamecar.domain;

import com.gamecar.gamecar.values.Dices;
import com.gamecar.gamecar.values.DriverId;
import com.gamecar.gamecar.values.PlayerId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Driver {

    @Id
    private DriverId driverId;
    private Dices dices;
    private PlayerId playerId;

    public DriverId getDriverId() {
        return driverId;
    }

    public void setDriverId(DriverId driverId) {
        this.driverId = driverId;
    }

    public Dices getDices() {
        return dices;
    }

    public void setDices(Dices dices) {
        this.dices = dices;
    }

    public PlayerId getPlayerId() {
        return playerId;
    }

    public void setPlayerId(PlayerId playerId) {
        this.playerId = playerId;
    }
}
