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
class UseCasePodiumEditTest {


    @SpyBean
    UseCasePodiumEdit useCasePodiumEdit;

    @MockBean
    RepositoryPodium repositoryPodium;

    @Test
    void editPodium(){
        var podiumDTO = new PodiumDTO("3","4","Andrea","Sara","Manuel");
        var podium = new Podium();
        podium.setPodiumId("3");
        podium.setDriverId("4");
        podium.setFirstPlace("Andrea");
        podium.setSecondPlace("Sara");
        podium.setThirdPlace("Manuel");


        when(repositoryPodium.save(Mockito.any(Podium.class))).thenReturn(Mono.just(podium));

        var response = useCasePodiumEdit.editPodium(podiumDTO);

        Assertions.assertEquals(response.block(), podiumDTO);
    }

}