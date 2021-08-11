package com.gamecar.gamecar.repository;

import com.gamecar.gamecar.domain.Rail;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface RepositoryRail extends ReactiveMongoRepository<Rail, String> {
}
