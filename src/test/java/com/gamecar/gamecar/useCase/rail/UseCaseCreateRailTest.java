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
class UseCaseCreateRailTest {


    @SpyBean
    UseCaseCreateRail useCaseCreateRail;

    @MockBean
    RepositoryRail repositoryRail;

    @Test
    void createRail(){
        RailDTO railDTO = new RailDTO("34","8","12",4,"9","11");
        Rail rail = new Rail();
        rail.setRailId("34");
        rail.setCarId("8");
        rail.setDriverId("12");
        rail.setActualPosition(4);
        rail.setGameId("9");
        rail.setTrackId("11");

        when(repositoryRail.save(Mockito.any(Rail.class))).thenReturn(Mono.just(rail));

        Mono<RailDTO> response = useCaseCreateRail.createRail(railDTO);

        Assertions.assertEquals(response.block(), railDTO);
    }

}