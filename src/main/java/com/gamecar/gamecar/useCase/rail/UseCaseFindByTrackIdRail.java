package com.gamecar.gamecar.useCase.rail;

import com.gamecar.gamecar.dto.RailDTO;
import com.gamecar.gamecar.repository.RepositoryRail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Flux;

@Service
@Validated
public class UseCaseFindByTrackIdRail {

    private final RepositoryRail repositoryRail;


    @Autowired
    public UseCaseFindByTrackIdRail(RepositoryRail repositoryRail) {
        this.repositoryRail = repositoryRail;
    }

    public Flux<RailDTO>getRailByTrackId(String id){
        return repositoryRail.findByTrackId(id);
    }
}
