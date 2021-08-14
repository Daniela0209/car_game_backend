package com.gamecar.gamecar.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@Document(collection = "Track")
public class TrackDTO {

    @Id
    private String trackId;
    private String  trackdistance;


}
