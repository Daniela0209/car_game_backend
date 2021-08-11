package com.gamecar.gamecar.repository;

import com.gamecar.gamecar.domain.Track;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface RepositoryTrack extends ReactiveMongoRepository<Track, String> {
}
