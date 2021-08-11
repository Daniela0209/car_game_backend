package com.gamecar.gamecar.dto;


public class TrackDTO {

    private String pistaId;
    private String  trackdistance;

    public TrackDTO(){

    }

    public String getPistaId() {
        return pistaId;
    }

    public void setPistaId(String pistaId) {
        this.pistaId = pistaId;
    }

    public String getTrackdistance() {
        return trackdistance;
    }

    public void setTrackdistance(String trackdistance) {
        this.trackdistance = trackdistance;
    }
}
