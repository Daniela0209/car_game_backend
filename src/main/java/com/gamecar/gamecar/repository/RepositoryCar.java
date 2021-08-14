package com.gamecar.gamecar.repository;

import com.gamecar.gamecar.dto.CarDTO;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface RepositoryCar extends ReactiveMongoRepository<CarDTO, String> {
}
