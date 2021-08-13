package com.gamecar.gamecar.values;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class WinnerPosition {

    private final Integer value;

    public WinnerPosition incrementValue(Integer value){
        return new WinnerPosition(value);
    }


}
