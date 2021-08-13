package com.gamecar.gamecar.values.id;

import lombok.AllArgsConstructor;


@AllArgsConstructor
public class PlayerId {

    private final String value;

    public static PlayerId of(String value){
        return  new PlayerId(value);
    }
    public String getValue(){
        return this.value;
    }

}
