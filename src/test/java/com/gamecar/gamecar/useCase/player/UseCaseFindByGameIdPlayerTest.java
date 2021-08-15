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
import reactor.core.publisher.Flux;

import static org.mockito.Mockito.when;

@SpringBootTest
class UseCaseFindByGameIdPlayerTest {

    @SpyBean
    UseCaseFindByGameIdPlayer useCaseFindByGameIdPlayer;

    @MockBean
    RepositoryPlayer repositoryPlayer;

    @Test
    void findByIdGame(){
        var playerDTO = new PlayerDTO("12","sandra",2,1,0,"23","10");
        var player = new Player();
        player.setPlayerId("12");
        player.setNamePlayer("sandra");
        player.setFirstPosition(2);
        player.setSecondPosition(1);
        player.setThirdPosition(0);
        player.setGameId("23");
        player.setDriverId("10");


        when(repositoryPlayer.findByGameId(Mockito.any(String.class))).thenReturn(Flux.just(player));

        var response = useCaseFindByGameIdPlayer.getPlayerByGameId(playerDTO.getGameId());

        Assertions.assertEquals(response.blockFirst().getGameId(), "23");
    }
}