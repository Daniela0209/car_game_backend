package com.gamecar.gamecar.useCase.podium;

import com.gamecar.gamecar.domain.Podium;
import com.gamecar.gamecar.dto.PodiumDTO;
import com.gamecar.gamecar.repository.RepositoryPodium;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import reactor.core.publisher.Mono;

import static org.mockito.Mockito.when;

@SpringBootTest
class UseCasePodiumFindByIdTest {

    @SpyBean
    UseCasePodiumFindById useCasePodiumFindById;

    @MockBean
    RepositoryPodium repositoryPodium;

    @Test
    void findByIdPodium(){
        var podiumDTO = new PodiumDTO("4","5","Gabriela","Sebas","Estefa");
        var podium = new Podium();
        podium.setPodiumId("4");
        podium.setDriverId("5");
        podium.setFirstPlace("Gabriela");
        podium.setSecondPlace("Sebas");
        podium.setThirdPlace("Estefa");


        when(repositoryPodium.findById(Mockito.any(String.class))).thenReturn(Mono.just(podium));

        var response = useCasePodiumFindById.getfindbyid(podiumDTO.getPodiumId());

        Assertions.assertEquals(response.block().getPodiumId(), "4");
    }

}