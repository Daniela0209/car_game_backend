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
public class UseCaseCreateDriver {

    private final RepositoryDriver repositoryDriver;
    private final MapperConductor mapperConductor;

    @Autowired
    public UseCaseCreateDriver(RepositoryDriver repositoryDriver, MapperConductor mapperConductor) {
        this.repositoryDriver = repositoryDriver;
        this.mapperConductor = mapperConductor;
    }

    public Mono<DriverDTO> apply(DriverDTO driverDTO) {
        return repositoryDriver.save(mapperConductor.mapperDriver(driverDTO.getDriverId())
                .apply(driverDTO))
                .map(mapperConductor.mapperDriverDTO());
    }
}
