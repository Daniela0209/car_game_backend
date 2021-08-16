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
class UseCaseEditRailTest {

    @SpyBean
    UseCaseEditRail useCaseEditRail;

    @MockBean
    RepositoryRail repositoryRail;

    @Test
    void editRail(){
        RailDTO railDTO = new RailDTO("12","54","65",3,"8","11");
        Rail rail = new Rail();
        rail.setRailId("12");
        rail.setCarId("54");
        rail.setDriverId("65");
        rail.setActualPosition(3);
        rail.setGameId("8");
        rail.setTrackId("11");


        when(repositoryRail.save(Mockito.any(Rail.class))).thenReturn(Mono.just(rail));

        Mono<RailDTO> response = useCaseEditRail.editRail(railDTO);

        Assertions.assertEquals(response.block(), railDTO);
    }

}