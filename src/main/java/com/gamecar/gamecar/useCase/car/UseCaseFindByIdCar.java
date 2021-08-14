package com.gamecar.gamecar.useCase.car;


import com.gamecar.gamecar.dto.CarDTO;
import com.gamecar.gamecar.repository.RepositoryCar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

@Service
@Validated
public class UseCaseFindByIdCar {

    private final RepositoryCar repositoryCar;

    @Autowired
    public UseCaseFindByIdCar(RepositoryCar repositoryCar) {
        this.repositoryCar = repositoryCar;
    }

    public Mono<CarDTO> getfindbyid(String id){
        return repositoryCar.findById(id);
    }
}
