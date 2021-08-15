package com.gamecar.gamecar.useCase.driver;


import com.gamecar.gamecar.dto.DriverDTO;
import com.gamecar.gamecar.mapper.MapperConductor;
import com.gamecar.gamecar.repository.RepositoryDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

@Service
@Validated
public class UseCaseFindByIdDriver {

    private final RepositoryDriver repositoryDriver;
    private final MapperConductor mapperConductor;

    @Autowired
    public UseCaseFindByIdDriver(RepositoryDriver repositoryDriver, MapperConductor mapperConductor) {
        this.repositoryDriver = repositoryDriver;
        this.mapperConductor = mapperConductor;
    }

    public Mono<DriverDTO> getfindbyid(String id){
        return repositoryDriver.findById(id)
                .flatMap(driver ->
                        Mono.just(mapperConductor.mapperDriverDTO().apply(driver)));
    }
}
