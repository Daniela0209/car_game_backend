package com.gamecar.gamecar.values.id;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class RailId {

    private final String value;

    public static RailId of(String value){
        return new RailId(value);
    }
    public String getValue(){
        return this.value;
    }


}

