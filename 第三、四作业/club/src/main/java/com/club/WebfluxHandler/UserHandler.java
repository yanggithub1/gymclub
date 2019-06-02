package com.club.WebfluxHandler;

import com.club.model.CourseEntity;
import com.club.model.UserEntity;
import com.club.repository.UserRepositoryImpl;
import com.club.repository.courseRepository;
import com.club.repository.userRepository;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.BodyInserters.fromObject;

public class UserHandler {
    private UserRepositoryImpl userRepository;

    public UserHandler(UserRepositoryImpl userRepository) {
        this.userRepository=userRepository;
    }

    public Mono<ServerResponse> getAll(ServerRequest request) {
        Flux<UserEntity> userEntityFlux=userRepository.getAll();
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(userEntityFlux,UserEntity.class);
    }

    public Mono<ServerResponse> getByid(ServerRequest request) {
        int userid=Integer.valueOf(request.pathVariable("id"));
        Mono<ServerResponse> notFound = ServerResponse.notFound().build();
        Mono<UserEntity> userEntityMono = userRepository.getByid(userid);
        return userEntityMono.flatMap(CourseEntity->ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(userEntityMono,UserEntity.class));
    }

    public Mono<ServerResponse> postUser(ServerRequest request) {
        Mono<UserEntity> userEntityMono = request.bodyToMono(UserEntity.class);
        return ServerResponse.ok().build(userRepository.saveUser(userEntityMono));
    }

    public Mono<ServerResponse> putUser(ServerRequest request) {
        int userId = Integer.valueOf(request.pathVariable("id"));
        Mono<UserEntity> userEntityMono = request.bodyToMono(UserEntity.class);
        Mono<UserEntity> responseMono =  userRepository.putUser(userEntityMono);
        return responseMono
                .flatMap(user -> ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(fromObject(user)));
    }

    public Mono<ServerResponse> deleteUser(ServerRequest request) {
        int userId = Integer.valueOf(request.pathVariable("id"));
        Mono<String> responseMono = userRepository.deleteUser(userId);
        return responseMono
                .flatMap(strMono -> ServerResponse.ok().contentType(MediaType.TEXT_PLAIN).body(fromObject(strMono)));
    }
}
