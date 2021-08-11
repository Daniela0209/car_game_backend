package com.gamecar.gamecar.values;

import java.util.UUID;

public class CarId {

    private UUID id;

    public CarId(UUID id) {
        this.id = id;
    }

    public String getId() {
        return id.toString();
    }
}
