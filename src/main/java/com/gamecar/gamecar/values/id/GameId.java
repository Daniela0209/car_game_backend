package com.gamecar.gamecar.values.id;


import lombok.AllArgsConstructor;

@AllArgsConstructor
public class GameId {


    private final String value;

    public static GameId of(String value){
        return new GameId(value);
    }
    public String getValue(){
        return this.value;
    }

}
