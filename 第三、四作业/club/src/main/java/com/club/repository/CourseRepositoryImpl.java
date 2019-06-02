package com.club.repository;

import com.club.model.CourseEntity;
import com.club.model.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class CourseRepositoryImpl {
    @Autowired
    private courseRepository courseRepository;

    public Flux<CourseEntity> getAll() {
        return Flux.fromIterable(courseRepository.findAll());
    }

    public Mono<CourseEntity> getByid(int id) {
        return Mono.just(courseRepository.findOne(id));
    }

    public Mono<Void> saveUser(Mono<CourseEntity> courseEntityMono) {
        Mono<CourseEntity> reponseMono =  courseEntityMono.doOnNext(course -> {
            courseRepository.save(course);
        });
        return reponseMono.then();
    }

    public Mono<CourseEntity> putUser(Mono<CourseEntity> courseEntityMono) {
        Mono<CourseEntity> responseMono =  courseEntityMono.doOnNext(course -> {
            courseRepository.saveAndFlush(course);
        });
        return responseMono;
    }

    public Mono<String> deleteUser(int id) {
        courseRepository.delete(id);
        return Mono.just("Deleted");
    }
}
