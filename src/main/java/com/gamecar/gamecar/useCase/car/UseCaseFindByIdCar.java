package com.gamecar.gamecar.useCase.car;


import com.gamecar.gamecar.dto.CarDTO;
import com.gamecar.gamecar.mapper.MapperCarro;
import com.gamecar.gamecar.repository.RepositoryCar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

@Service
@Validated
public class UseCaseFindByIdCar {

    private final RepositoryCar repositoryCar;
    private final MapperCarro mapperCarro;

    @Autowired
    public UseCaseFindByIdCar(RepositoryCar repositoryCar, MapperCarro mapperCarro) {
        this.repositoryCar = repositoryCar;
        this.mapperCarro = mapperCarro;
    }


    public Mono<CarDTO> getfindbyid(String id){
        return repositoryCar.findById(id)
                .flatMap(car ->
                        Mono.just(mapperCarro.mapperCarDTO().apply(car)));
    }
}
