package com.club.repository;


import com.club.model.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class UserRepositoryImpl {

    @Autowired
    private userRepository userRepository;

    public Flux<UserEntity> getAll() {
        return Flux.fromIterable(userRepository.findAll());
    }

    public Mono<UserEntity> getByid(int id) {
        return Mono.just(userRepository.findOne(id));
    }

    public Mono<Void> saveUser(Mono<UserEntity> userEntityMono) {
        Mono<UserEntity> reponseMono =  userEntityMono.doOnNext(user -> {
            userRepository.save(user);
        });
        return reponseMono.then();
    }

    public Mono<UserEntity> putUser(Mono<UserEntity> userEntityMono) {
        Mono<UserEntity> responseMono =  userEntityMono.doOnNext(user -> {
            userRepository.saveAndFlush(user);
        });
        return responseMono;
    }

    public Mono<String> deleteUser(int id) {
        userRepository.delete(id);
        return Mono.just("Deleted");
    }
}
