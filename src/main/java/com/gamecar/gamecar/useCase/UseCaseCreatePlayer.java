package com.gamecar.gamecar.useCase;


import com.gamecar.gamecar.repository.RepositoryPlayer;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class UseCaseCreatePlayer {

    private final RepositoryPlayer repositoryPlayer;


    public UseCaseCreatePlayer(RepositoryPlayer repositoryPlayer) {
        this.repositoryPlayer = repositoryPlayer;
    }
}
