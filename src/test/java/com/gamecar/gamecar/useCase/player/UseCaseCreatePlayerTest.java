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
class UseCaseCreatePlayerTest {

    @SpyBean
    UseCaseCreatePlayer useCaseCreatePlayer;

    @MockBean
    RepositoryPlayer repositoryPlayer;

    @Test
    void createPlayer(){
        PlayerDTO playerDTO = new PlayerDTO("34","Daniela",3,1,0,"12","34");
        Player player = new Player();
        player.setPlayerId("34");
        player.setNamePlayer("Daniela");
        player.setFirstPosition(3);
        player.setSecondPosition(1);
        player.setThirdPosition(0);
        player.setGameId("12");
        player.setDriverId("34");


        when(repositoryPlayer.save(Mockito.any(Player.class))).thenReturn(Mono.just(player));

        Mono<PlayerDTO> response = useCaseCreatePlayer.createPlayer(playerDTO);

        Assertions.assertEquals(response.block(), playerDTO);

    }



}