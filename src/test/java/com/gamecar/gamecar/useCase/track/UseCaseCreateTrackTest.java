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
class UseCaseCreateTrackTest {


    @SpyBean
    UseCaseCreateTrack useCaseCreateTrack;

    @MockBean
    RepositoryTrack repositoryTrack;

    @Test
    void createTrack(){
        var trackDTO = new  TrackDTO("3","12");
        var track = new Track();
        track.setTrackId("3");
        track.setTrackdistance("12");



        when(repositoryTrack.save(Mockito.any(Track.class))).thenReturn(Mono.just(track));

        var response = useCaseCreateTrack.apply(trackDTO);

        Assertions.assertEquals(response.block(), trackDTO);
    }

}