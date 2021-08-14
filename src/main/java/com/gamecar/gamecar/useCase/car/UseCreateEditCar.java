package com.gamecar.gamecar.useCase.car;


import com.gamecar.gamecar.dto.CarDTO;
import com.gamecar.gamecar.repository.RepositoryCar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

@Service
@Validated
public class UseCreateEditCar {

    private final RepositoryCar repositoryCar;
    @Autowired
    public UseCreateEditCar(RepositoryCar repositoryCar) {
        this.repositoryCar = repositoryCar;
    }

    public Mono<CarDTO> apply(CarDTO carDTO){
        return repositoryCar
                .save(carDTO)
                .thenReturn(carDTO);
    }
}


