package com.gamecar.gamecar.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Document(collection = "Track")
public class TrackDTO {

    @Id
    private String trackId;
    private String  trackdistance;


    public TrackDTO(String toString, int parseInt, String gameId, Object o) {
    }
}
