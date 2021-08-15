package com.gamecar.gamecar.repository;

import com.gamecar.gamecar.domain.Game;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryGame extends ReactiveMongoRepository<Game, String> {
}
