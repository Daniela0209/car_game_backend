package com.gamecar.gamecar.useCase.track;


import com.gamecar.gamecar.dto.TrackDTO;
import com.gamecar.gamecar.repository.RepositoryTrack;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

@Service
@Validated
public class UseCaseFindByIdTrack {

    private final RepositoryTrack repositoryTrack;


    public UseCaseFindByIdTrack(RepositoryTrack repositoryTrack) {
        this.repositoryTrack = repositoryTrack;
    }

    public Mono<TrackDTO> getfindbyid(String id){
        return repositoryTrack.findById(id);
    }
}
