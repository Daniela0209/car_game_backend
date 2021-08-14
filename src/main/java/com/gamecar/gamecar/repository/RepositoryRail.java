package com.gamecar.gamecar.repository;

import com.gamecar.gamecar.dto.RailDTO;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

public interface RepositoryRail extends ReactiveMongoRepository<RailDTO, String> {
    Flux<RailDTO> findByTrackId(String trackId);
}
