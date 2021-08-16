package com.gamecar.gamecar.useCase.track;


import com.gamecar.gamecar.domain.Track;
import com.gamecar.gamecar.dto.TrackDTO;
import com.gamecar.gamecar.repository.RepositoryTrack;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import reactor.core.publisher.Mono;

import static org.mockito.Mockito.when;

@SpringBootTest
class UseCaseEditTrackTest {

    @SpyBean
    UseCaseEditTrack useCaseEditTrack;

    @MockBean
    RepositoryTrack repositoryTrack;

    @Test
    void editTrack(){
        TrackDTO trackDTO = new TrackDTO("34","12");
        Track track = new Track();
        track.setTrackId("34");
        track.setTrackdistance("12");


        when(repositoryTrack.save(Mockito.any(Track.class))).thenReturn(Mono.just(track));

        Mono<TrackDTO> response = useCaseEditTrack.editTrack(trackDTO);

        Assertions.assertEquals(response.block(), trackDTO);
    }

}