package com.gamecar.gamecar.useCase.player;


import com.gamecar.gamecar.domain.Player;
import com.gamecar.gamecar.dto.PlayerDTO;
import com.gamecar.gamecar.repository.RepositoryPlayer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import reactor.core.publisher.Mono;

import static org.mockito.Mockito.when;

@SpringBootTest
class UseCaseFindByPlayerTest {

    @SpyBean
    UseCaseFindByPlayer useCaseFindByPlayer;

    @MockBean
    RepositoryPlayer repositoryPlayer;


    @Test
   void findByIdPlayer(){
        PlayerDTO playerDTO = new PlayerDTO("14","Gabriela",3,2,4,"12","8");
        Player player = new Player();
        player.setPlayerId("14");
        player.setNamePlayer("Gabriela");
        player.setFirstPosition(3);
        player.setSecondPosition(2);
        player.setThirdPosition(4);
        player.setGameId("12");
        player.setDriverId("8");

        when(repositoryPlayer.findById(Mockito.any(String.class))).thenReturn(Mono.just(player));

        Mono<PlayerDTO> response = useCaseFindByPlayer.findByIdPlayer(playerDTO.getPlayerId());

        Assertions.assertEquals(response.block().getPlayerId(), "14");
    }


}