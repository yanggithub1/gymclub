package com.club.repository;

import com.club.model.CoachEntity;
import com.club.model.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class CoachRepositoryImpl {
    @Autowired
    private coachRepository coachRepository;

    public Flux<CoachEntity> getAll() {
        return Flux.fromIterable(coachRepository.findAll());
    }

    public Mono<CoachEntity> getByid(int id) {
        return Mono.just(coachRepository.findOne(id));
    }

    public Mono<Void> saveUser(Mono<CoachEntity> userEntityMono) {
        Mono<CoachEntity> reponseMono =  userEntityMono.doOnNext(coach -> {
            coachRepository.save(coach);
        });
        return reponseMono.then();
    }

    public Mono<CoachEntity> putUser(Mono<CoachEntity> userEntityMono) {
        Mono<CoachEntity> responseMono =  userEntityMono.doOnNext(coach -> {
            coachRepository.saveAndFlush(coach);
        });
        return responseMono;
    }

    public Mono<String> deleteUser(int id) {
        coachRepository.delete(id);
        return Mono.just("Deleted");
    }
}
