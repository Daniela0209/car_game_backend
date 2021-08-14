package com.gamecar.gamecar.useCase.rail;


import com.gamecar.gamecar.dto.RailDTO;
import com.gamecar.gamecar.repository.RepositoryRail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;


@Service
@Validated
public class UseCaseEditRail {


    private final RepositoryRail repositoryRail;


    @Autowired
    public UseCaseEditRail(RepositoryRail repositoryRail ) {
        this.repositoryRail = repositoryRail;

    }
    public Mono<RailDTO> apply(RailDTO railDTO){
        return repositoryRail
                .save(railDTO)
                .thenReturn(railDTO);
    }
}
