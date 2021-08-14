package com.gamecar.gamecar.repository;

import com.gamecar.gamecar.dto.PlayerDTO;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;


public interface RepositoryPlayer extends ReactiveMongoRepository<PlayerDTO, String> {


}
