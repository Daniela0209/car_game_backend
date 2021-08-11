package com.gamecar.gamecar.dto;

public class PlayerDTO {

    private String playerId;
    private String namePlayer;

    public PlayerDTO(){

    }

    public PlayerDTO(String playerId, String namePlayer) {
        this.playerId = playerId;
        this.namePlayer = namePlayer;
    }

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
