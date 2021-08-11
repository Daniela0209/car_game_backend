package com.gamecar.gamecar.values;

import java.util.UUID;

public class CarrilId {

    private UUID id;

    public CarrilId(UUID id) {
        this.id = id;
    }

    public String getId() {
        return id.toString();
    }
}

