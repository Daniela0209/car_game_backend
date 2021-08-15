package com.gamecar.gamecar.repository;

import com.gamecar.gamecar.domain.Rail;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface RepositoryRail extends ReactiveMongoRepository<Rail, String> {
    Flux<Rail> findByTrackId(String trackId);
}
