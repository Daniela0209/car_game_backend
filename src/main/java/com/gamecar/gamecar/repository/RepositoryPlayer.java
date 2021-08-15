package com.gamecar.gamecar.repository;

import com.gamecar.gamecar.domain.Player;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface RepositoryPlayer extends ReactiveMongoRepository<Player, String> {

    Flux<Player> findByGameId(String gameId);
}
