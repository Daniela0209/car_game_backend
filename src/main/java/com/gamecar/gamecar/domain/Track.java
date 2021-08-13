package com.gamecar.gamecar.domain;

import com.gamecar.gamecar.values.id.TrackId;
import com.gamecar.gamecar.values.Trackdistance;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@AllArgsConstructor
@RequiredArgsConstructor
@Document(collection = "Track")
public class Track {

    @Id
    private TrackId trackId;
    private Trackdistance trackdistance;

}
