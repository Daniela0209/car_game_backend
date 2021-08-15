package com.gamecar.gamecar.mapper;

import com.gamecar.gamecar.domain.Track;
import com.gamecar.gamecar.dto.TrackDTO;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class MapperPista {

    public Function<TrackDTO, Track> mapperTrack(String id) {
        return dataTrack -> {
            Track track = new Track();
            track.setTrackId(dataTrack.getTrackId());
            track.setTrackdistance(dataTrack.getTrackdistance());
            return track;
        };
    }

    public Function<Track, TrackDTO> mapperTrackDTO(){
        return track -> new TrackDTO(
                track.getTrackId(),
                track.getTrackdistance()
        );
}
}