package com.gamecar.gamecar.values;

import java.util.UUID;

public class PistaId {


    private final UUID id;

    public PistaId(UUID id) {
        this.id = id;
    }

    public String getId() {
        return id.toString();
    }

}
