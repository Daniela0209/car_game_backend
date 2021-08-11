package com.gamecar.gamecar.values;

import java.util.UUID;

public class PlayId {


    private final UUID id;

    public PlayId(UUID id) {
        this.id = id;
    }

    public String getId() {
        return id.toString();
    }
}
