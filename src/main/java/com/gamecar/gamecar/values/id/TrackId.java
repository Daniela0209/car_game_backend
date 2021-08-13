package com.gamecar.gamecar.values.id;


import lombok.AllArgsConstructor;

@AllArgsConstructor
public class TrackId {


    private final String value;

    public static TrackId of(String value){
        return  new TrackId(value);
    }

    public String getValue(){
        return this.value;
    }

}
