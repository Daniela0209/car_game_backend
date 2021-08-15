package com.gamecar.gamecar.repository;


import com.gamecar.gamecar.domain.Podium;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryPodium extends ReactiveMongoRepository<Podium, String> {
}
