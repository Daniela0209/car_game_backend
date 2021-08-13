package com.gamecar.gamecar.useCase;


import com.gamecar.gamecar.dto.RailDTO;
import com.gamecar.gamecar.mapper.MapperRail;
import com.gamecar.gamecar.repository.RepositoryRail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

@Service
@Validated
public class UseCaseCreateRail {

    private final RepositoryRail repositoryRail;
    private final MapperRail mapperRail;


    @Autowired
    public UseCaseCreateRail(RepositoryRail repositoryRail, MapperRail mapperRail) {
        this.repositoryRail = repositoryRail;
        this.mapperRail = mapperRail;
    }

    public Mono<RailDTO> apply(RailDTO railDTO){
        return repositoryRail
                .save(mapperRail.mapperRail(railDTO.getRailId())
                .apply(railDTO))
                .thenReturn(railDTO);


    }



}
