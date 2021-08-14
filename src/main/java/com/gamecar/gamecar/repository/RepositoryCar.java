package com.gamecar.gamecar.repository;

import com.gamecar.gamecar.dto.CarDTO;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

public interface RepositoryCar extends ReactiveMongoRepository<CarDTO, String> {
    Flux<CarDTO> findByDriverId(String driverId);
}
