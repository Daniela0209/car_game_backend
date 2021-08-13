package com.gamecar.gamecar.repository;

import com.gamecar.gamecar.domain.Player;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;


public interface RepositoryPlayer extends ReactiveMongoRepository<Player, String> {


}
