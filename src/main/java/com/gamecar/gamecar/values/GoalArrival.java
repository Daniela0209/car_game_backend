package com.gamecar.gamecar.values;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class GoalArrival {

    private final Boolean value;

    public GoalArrival trueValue() {
        return new GoalArrival(Boolean.TRUE);
    }
}

