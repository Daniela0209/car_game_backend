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
class UseCaseFindByIdTrackTest {

    @SpyBean
    UseCaseFindByIdTrack useCaseFindByIdTrack;

    @MockBean
    RepositoryTrack repositoryTrack;

    @Test
    void findBYIdTrack(){
        TrackDTO trackDTO = new TrackDTO("400","123");
        Track track = new Track();
        track.setTrackId("400");
        track.setTrackdistance("123");

        when(repositoryTrack.findById(Mockito.any(String.class))).thenReturn(Mono.just(track));

        Mono<TrackDTO> response = useCaseFindByIdTrack.getfindbyid(trackDTO.getTrackId());

        Assertions.assertEquals(response.block().getTrackId(), "400");
    }

}