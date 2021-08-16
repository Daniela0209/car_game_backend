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
import reactor.core.publisher.Mono;

import static org.mockito.Mockito.when;

@SpringBootTest
class UseCaseFindByIdRialTest {

    @SpyBean
    UseCaseFindByIdRial useCaseFindByIdRial;

    @MockBean
    RepositoryRail repositoryRail;

    @Test
    void findByIdRail(){
        RailDTO railDTO = new RailDTO("4","5","12",5,"45","15");
        Rail rail = new Rail();
        rail.setRailId("4");
        rail.setCarId("5");
        rail.setDriverId("12");
        rail.setActualPosition(5);
        rail.setGameId("45");
        rail.setTrackId("15");

        when(repositoryRail.findById(Mockito.any(String.class))).thenReturn(Mono.just(rail));

        Mono<RailDTO> response = useCaseFindByIdRial.getfindbyid(railDTO.getRailId());

        Assertions.assertEquals(response.block().getRailId(), "4");
    }

}