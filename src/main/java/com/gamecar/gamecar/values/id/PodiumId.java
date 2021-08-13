package com.gamecar.gamecar.values.id;


import lombok.AllArgsConstructor;

@AllArgsConstructor
public class PodiumId {


    private final String value;


    public static DriverId of(String value){
        return  new DriverId(value);
    }

    public String getValue(){
        return this.value;
    }
}
