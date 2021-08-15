package com.gamecar.gamecar.useCase.rail;


import com.gamecar.gamecar.domain.Rail;
import com.gamecar.gamecar.dto.RailDTO;
import com.gamecar.gamecar.repository.RepositoryRail;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import reactor.core.publisher.Flux;

import static org.mockito.Mockito.when;

@SpringBootTest
class UseCaseFindByTrackIdRailTest {

    @SpyBean
    UseCaseFindByTrackIdRail useCaseFindByTrackIdRail;

    @MockBean
    RepositoryRail repositoryRail;

     @Test
    void findIdTrack(){
         var railDTO = new RailDTO("2","12","19",5,"14","1");
         var rail = new Rail();
         rail.setRailId("2");
         rail.setCarId("12");
         rail.setDriverId("19");
         rail.setActualPosition(5);
         rail.setGameId("14");
         rail.setTrackId("1");

         when(repositoryRail.findByTrackId(Mockito.any(String.class))).thenReturn(Flux.just(rail));

         var response = useCaseFindByTrackIdRail.getRailByTrackId(railDTO.getTrackId());

         Assertions.assertEquals(response.blockFirst().getTrackId(), "1");
     }
}