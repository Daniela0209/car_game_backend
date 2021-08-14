package com.gamecar.gamecar.repository;

import com.gamecar.gamecar.dto.DriverDTO;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface RepositoryDriver extends ReactiveMongoRepository<DriverDTO, String> {
}
