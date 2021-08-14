package com.gamecar.gamecar.useCase.player;

import com.gamecar.gamecar.dto.PlayerDTO;
import com.gamecar.gamecar.repository.RepositoryPlayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

@Service
@Validated
public class UseCaseCreatePlayer {

    private final RepositoryPlayer repositoryPlayer;


    @Autowired
    public UseCaseCreatePlayer(RepositoryPlayer repositoryPlayer ) {
        this.repositoryPlayer = repositoryPlayer;
    }



        public Mono<PlayerDTO> apply(PlayerDTO playerDTO){
            return repositoryPlayer
                            .save(playerDTO)
                            .thenReturn(playerDTO);

    }


}
