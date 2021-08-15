package com.gamecar.gamecar.useCase.rail;

import com.gamecar.gamecar.dto.RailDTO;
import com.gamecar.gamecar.mapper.MapperCarril;
import com.gamecar.gamecar.repository.RepositoryRail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Flux;

@Service
@Validated
public class UseCaseFindByTrackIdRail {

    private final RepositoryRail repositoryRail;
    private final MapperCarril mapperCarril;

    @Autowired
    public UseCaseFindByTrackIdRail(RepositoryRail repositoryRail, MapperCarril mapperCarril) {
        this.repositoryRail = repositoryRail;
        this.mapperCarril = mapperCarril;
    }

    public Flux<RailDTO>getRailByTrackId(String id){
        return repositoryRail.findByTrackId(id)
                .flatMap(
                        rail -> Flux.just(mapperCarril.mapperRailDTO().apply(rail))
                );
    }
}
