package com.gamecar.gamecar.useCase.player;


import com.gamecar.gamecar.dto.PlayerDTO;
import com.gamecar.gamecar.mapper.MapperJugador;
import com.gamecar.gamecar.repository.RepositoryPlayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Flux;

@Service
@Validated
public class UseCaseFindByGameIdPlayer {

    private final RepositoryPlayer repositoryPlayer;
    private final MapperJugador mapperJugador;


    @Autowired
    public UseCaseFindByGameIdPlayer(RepositoryPlayer repositoryPlayer, MapperJugador mapperJugador) {
        this.repositoryPlayer = repositoryPlayer;
        this.mapperJugador = mapperJugador;
    }

    public Flux<PlayerDTO> getPlayerByGameId(String id) {
        return repositoryPlayer.findByGameId(id)
                .flatMap(
                        player -> Flux.just(mapperJugador.mapperPlayerDTO().apply(player))
                );
    }
}

