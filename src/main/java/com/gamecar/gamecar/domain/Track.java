package com.gamecar.gamecar.domain;

import com.gamecar.gamecar.values.PistaId;
import com.gamecar.gamecar.values.Trackdistance;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Track {

    @Id
    private PistaId pistaId;
    private Trackdistance trackdistance;

    public PistaId getPistaId() {
        return pistaId;
    }

    public void setPistaId(PistaId pistaId) {
        this.pistaId = pistaId;
    }

    public Trackdistance getTrackdistance() {
        return trackdistance;
    }

    public void setTrackdistance(Trackdistance trackdistance) {
        this.trackdistance = trackdistance;
    }
}
