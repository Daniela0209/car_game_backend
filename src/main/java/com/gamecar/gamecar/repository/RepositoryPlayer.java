package com.gamecar.gamecar.repository;

import com.gamecar.gamecar.domain.Player;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface RepositoryPlayer extends ReactiveMongoRepository<Player, String> {

    Mono<Player> createPlayer (String playerId);
    Flux<Player> findAll(String playerId);
}
