package com.gamecar.gamecar.useCase;

import com.gamecar.gamecar.dto.PlayerDTO;
import com.gamecar.gamecar.mapper.MapperJugador;
import com.gamecar.gamecar.repository.RepositoryPlayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

@Service
@Validated
public class UseCaseCreatePlayer {

    private final RepositoryPlayer repositoryPlayer;
    private final MapperJugador mapperJugador;

    @Autowired
    public UseCaseCreatePlayer(RepositoryPlayer repositoryPlayer, MapperJugador mapperJugador) {
        this.repositoryPlayer = repositoryPlayer;
        this.mapperJugador = mapperJugador;
    }



        public Mono<PlayerDTO> apply(PlayerDTO playerDTO){
            var respuesta  = repositoryPlayer
                            .save(mapperJugador.mapperPlayer(null)
                            .apply(playerDTO))
                            .map(mapperJugador.mapperToPlayer(playerDTO));

            return respuesta;
    }
}
