package com.gamecar.gamecar.repository;

import com.gamecar.gamecar.domain.Track;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryTrack extends ReactiveMongoRepository<Track, String> {
}
