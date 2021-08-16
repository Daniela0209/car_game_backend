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
class UseCasePodiumCreateTest {

    @SpyBean
    UseCasePodiumCreate useCasePodiumCreate;

    @MockBean
    RepositoryPodium repositoryPodium;

    @Test
    void createPodium(){
        PodiumDTO podiumDTO = new PodiumDTO("2","5","Gabriela","Estefania","Daniela");
        Podium podium = new Podium();
        podium.setPodiumId("2");
        podium.setDriverId("5");
        podium.setFirstPlace("Gabriela");
        podium.setSecondPlace("Estefania");
        podium.setThirdPlace("Daniela");


        when(repositoryPodium.save(Mockito.any(Podium.class))).thenReturn(Mono.just(podium));

        Mono<PodiumDTO> response = useCasePodiumCreate.apply(podiumDTO);

        Assertions.assertEquals(response.block(), podiumDTO);
    }

}