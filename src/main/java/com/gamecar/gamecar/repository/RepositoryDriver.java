package com.gamecar.gamecar.repository;

import com.gamecar.gamecar.domain.Driver;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface RepositoryDriver extends ReactiveMongoRepository<Driver, String> {
}
