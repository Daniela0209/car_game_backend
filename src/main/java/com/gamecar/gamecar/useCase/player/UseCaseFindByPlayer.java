package com.gamecar.gamecar.useCase.player;


import com.gamecar.gamecar.dto.PlayerDTO;
import com.gamecar.gamecar.mapper.MapperJugador;
import com.gamecar.gamecar.repository.RepositoryPlayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

@Service
@Validated
public class UseCaseFindByPlayer {

    private final RepositoryPlayer repositoryPlayer;
    private final MapperJugador mapperJugador;

    @Autowired
    public UseCaseFindByPlayer(RepositoryPlayer repositoryPlayer, MapperJugador mapperJugador) {
        this.repositoryPlayer = repositoryPlayer;
        this.mapperJugador = mapperJugador;
    }


    public Mono<PlayerDTO> findByIdPlayer(String id) {
        return repositoryPlayer.findById(id)
                .map(mapperJugador.mapperPlayerDTO());
    }
}
