package com.gamecar.gamecar.useCase.rail;


import com.gamecar.gamecar.dto.RailDTO;
import com.gamecar.gamecar.mapper.MapperCarril;
import com.gamecar.gamecar.mapper.MapperPista;
import com.gamecar.gamecar.repository.RepositoryRail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

@Service
@Validated
public class UseCaseCreateRail {

    private final RepositoryRail repositoryRail;
    private final MapperCarril mapperCarril;

    @Autowired
    public UseCaseCreateRail(RepositoryRail repositoryRail, MapperPista mapperPista, RepositoryRail repositoryRail1, MapperCarril mapperCarril) {
        this.repositoryRail = repositoryRail1;
        this.mapperCarril = mapperCarril;
    }


    public Mono<RailDTO> createRail(RailDTO railDTO){
        return repositoryRail
                .save(mapperCarril.mapperRail(railDTO.getRailId())
                        .apply(railDTO))
                .map(mapperCarril.mapperRailDTO());
    }

    }

