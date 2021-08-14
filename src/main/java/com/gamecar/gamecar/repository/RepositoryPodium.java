package com.gamecar.gamecar.repository;


import com.gamecar.gamecar.dto.PodiumDTO;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface RepositoryPodium extends ReactiveMongoRepository<PodiumDTO, String> {
}
