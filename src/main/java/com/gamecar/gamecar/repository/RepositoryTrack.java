package com.gamecar.gamecar.repository;

import com.gamecar.gamecar.dto.TrackDTO;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface RepositoryTrack extends ReactiveMongoRepository<TrackDTO, String> {
}
