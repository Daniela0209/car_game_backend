package com.gamecar.gamecar.repository;

import com.gamecar.gamecar.domain.Car;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
@Repository
public interface RepositoryCar extends ReactiveMongoRepository<Car, String> {
    Flux<Car> findByDriverId(String driverId);
}
