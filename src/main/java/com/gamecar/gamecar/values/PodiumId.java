package com.gamecar.gamecar.values;

import java.util.UUID;

public class PodiumId {


    private UUID id;

    public PodiumId(UUID id) {
        this.id = id;
    }

    public String getId() {
        return id.toString();
    }
}
