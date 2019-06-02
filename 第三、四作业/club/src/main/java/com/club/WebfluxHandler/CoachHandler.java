package com.club.WebfluxHandler;

import com.club.model.CoachEntity;
import com.club.model.CourseEntity;
import com.club.repository.CoachRepositoryImpl;
import com.club.repository.coachRepository;
import com.club.repository.courseRepository;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.BodyInserters.fromObject;

public class CoachHandler {
    private CoachRepositoryImpl coachRepository;

    public CoachHandler(CoachRepositoryImpl coachRepository) {
        this.coachRepository=coachRepository;
    }

    public Mono<ServerResponse> getAll(ServerRequest request) {
        Flux<CoachEntity> coachEntityFlux=coachRepository.getAll();
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(coachEntityFlux,CoachEntity.class);
    }

    public Mono<ServerResponse> getByid(ServerRequest request) {
        int coachid=Integer.valueOf(request.pathVariable("id"));
        Mono<ServerResponse> notFound = ServerResponse.notFound().build();
        Mono<CoachEntity> coachEntityMono = coachRepository.getByid(coachid);
        return coachEntityMono.flatMap(CourseEntity->ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(coachEntityMono,CoachEntity.class));
    }

    public Mono<ServerResponse> postCoach(ServerRequest request) {
        Mono<CoachEntity> coachEntityMono = request.bodyToMono(CoachEntity.class);
        return ServerResponse.ok().build(coachRepository.saveUser(coachEntityMono));
    }

    public Mono<ServerResponse> putCoach(ServerRequest request) {
        int coachId = Integer.valueOf(request.pathVariable("id"));
        Mono<CoachEntity> coachEntityMono = request.bodyToMono(CoachEntity.class);
        Mono<CoachEntity> responseMono = coachRepository.putUser(coachEntityMono);
        return responseMono
                .flatMap(course -> ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(fromObject(course)));
    }

    public Mono<ServerResponse> deleteCoach(ServerRequest request) {
        int coachId = Integer.valueOf(request.pathVariable("id"));
        Mono<String> responseMono = coachRepository.deleteUser(coachId);
        return responseMono
                .flatMap(strMono -> ServerResponse.ok().contentType(MediaType.TEXT_PLAIN).body(fromObject(strMono)));
    }
}
