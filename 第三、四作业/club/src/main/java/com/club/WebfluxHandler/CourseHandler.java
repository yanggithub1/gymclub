package com.club.WebfluxHandler;

import com.club.model.CourseEntity;
import com.club.repository.CourseRepositoryImpl;
import com.club.repository.courseRepository;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.web.reactive.function.BodyInserters.fromObject;


@Component
public class CourseHandler {
    private CourseRepositoryImpl courseRepository;

    public CourseHandler(CourseRepositoryImpl courseRepository) {
        this.courseRepository=courseRepository;
    }

    public Mono<ServerResponse> getAll(ServerRequest request) {
        Flux<CourseEntity> courseEntityFlux=courseRepository.getAll();
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(courseEntityFlux,CourseEntity.class);
    }




    public Mono<ServerResponse> getByid(ServerRequest request) {
        int courseid=Integer.valueOf(request.pathVariable("id"));
        Mono<ServerResponse> notFound = ServerResponse.notFound().build();
        Mono<CourseEntity> courseEntityMono = courseRepository.getByid(courseid);
        return courseEntityMono.flatMap(CourseEntity->ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(courseEntityMono,CourseEntity.class));
    }

    public Mono<ServerResponse> postCourse(ServerRequest request) {
        Mono<CourseEntity> courseEntityMono = request.bodyToMono(CourseEntity.class);
        return ServerResponse.ok().build(courseRepository.saveUser(courseEntityMono));
    }

    public Mono<ServerResponse> putCourse(ServerRequest request) {
        int courseId = Integer.valueOf(request.pathVariable("id"));
        Mono<CourseEntity> courseEntityMono = request.bodyToMono(CourseEntity.class);
        Mono<CourseEntity> responseMono =  courseRepository.putUser(courseEntityMono);
        return responseMono
                .flatMap(course -> ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(fromObject(course)));
    }

    public Mono<ServerResponse> deleteCourse(ServerRequest request) {
        int courseId = Integer.valueOf(request.pathVariable("id"));
        Mono<String> responseMono = courseRepository.deleteUser(courseId);
        return responseMono
                .flatMap(strMono -> ServerResponse.ok().contentType(MediaType.TEXT_PLAIN).body(fromObject(strMono)));
    }

}
