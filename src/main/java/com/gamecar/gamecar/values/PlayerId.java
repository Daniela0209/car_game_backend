package com.gamecar.gamecar.values;

import java.util.UUID;

public class PlayerId {

    private final UUID id;

    public PlayerId(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }
}
