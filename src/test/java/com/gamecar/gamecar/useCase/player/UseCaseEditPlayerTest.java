package com.gamecar.gamecar.useCase.player;

import com.gamecar.gamecar.domain.Car;
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
class UseCaseEditPlayerTest {

    @SpyBean
    UseCaseEditPlayer useCaseEditPlayer;

    @MockBean
    RepositoryPlayer repositoryPlayer;

    @Test
    void editPlayer(){
        var playerDTO = new PlayerDTO("23","Gabriela",3,4,5,"4","12");
        var player = new Player();
        player.setPlayerId("23");
        player.setNamePlayer("Gabriela");
        player.setFirstPosition(3);
        player.setSecondPosition(4);
        player.setThirdPosition(5);
        player.setGameId("4");
        player.setDriverId("12");


        when(repositoryPlayer.save(Mockito.any(Player.class))).thenReturn(Mono.just(player));

        var response = useCaseEditPlayer.editPlayer(playerDTO);

        Assertions.assertEquals(response.block(), playerDTO);
    }



}