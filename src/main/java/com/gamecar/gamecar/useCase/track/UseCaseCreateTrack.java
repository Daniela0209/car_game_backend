package com.gamecar.gamecar.useCase.track;


import com.gamecar.gamecar.dto.TrackDTO;
import com.gamecar.gamecar.repository.RepositoryTrack;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

@Service
@Validated
public class UseCaseCreateTrack {

    private final RepositoryTrack repositoryTrack;


    public UseCaseCreateTrack(RepositoryTrack repositoryTrack) {
        this.repositoryTrack = repositoryTrack;
    }

    public Mono<TrackDTO> apply(TrackDTO trackDTO){
        return repositoryTrack
                .save(trackDTO)
                .thenReturn(trackDTO);
    }
}
