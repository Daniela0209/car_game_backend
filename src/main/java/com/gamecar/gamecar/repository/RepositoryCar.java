package com.gamecar.gamecar.repository;

import com.gamecar.gamecar.domain.Car;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface RepositoryCar extends ReactiveMongoRepository<Car, String> {
}
