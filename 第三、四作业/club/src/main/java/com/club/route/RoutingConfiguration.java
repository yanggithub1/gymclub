package com.club.route;

import com.club.WebfluxHandler.CoachHandler;
import com.club.WebfluxHandler.CourseHandler;
import com.club.WebfluxHandler.UserHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class RoutingConfiguration {

    @Bean
    public RouterFunction<ServerResponse> monoRouterFunctionCourse(CourseHandler courseHandler) {
        return route(GET("/api/customer").and(accept(MediaType.APPLICATION_JSON)), courseHandler::getAll)
                .andRoute(GET("/api/customer/{id}").and(accept(MediaType.APPLICATION_JSON)), courseHandler::getByid)
                .andRoute(POST("/api/customer/post").and(accept(MediaType.APPLICATION_JSON)), courseHandler::postCourse)
                .andRoute(PUT("/api/customer/put/{id}").and(accept(MediaType.APPLICATION_JSON)), courseHandler::putCourse)
                .andRoute(DELETE("/api/customer/delete/{id}").and(accept(MediaType.APPLICATION_JSON)), courseHandler::deleteCourse);
    }

    @Bean
    public RouterFunction<ServerResponse> monoRouterFunctionUser(UserHandler userHandler) {
        return route(GET("/api/customer").and(accept(MediaType.APPLICATION_JSON)), userHandler::getAll)
                .andRoute(GET("/api/customer/{id}").and(accept(MediaType.APPLICATION_JSON)), userHandler::getByid)
                .andRoute(POST("/api/customer/post").and(accept(MediaType.APPLICATION_JSON)), userHandler::postUser)
                .andRoute(PUT("/api/customer/put/{id}").and(accept(MediaType.APPLICATION_JSON)), userHandler::putUser)
                .andRoute(DELETE("/api/customer/delete/{id}").and(accept(MediaType.APPLICATION_JSON)), userHandler::deleteUser);
    }

    @Bean
    public RouterFunction<ServerResponse> monoRouterFunctionCoach(CoachHandler coachHandler) {
        return route(GET("/api/customer").and(accept(MediaType.APPLICATION_JSON)), coachHandler::getAll)
                .andRoute(GET("/api/customer/{id}").and(accept(MediaType.APPLICATION_JSON)), coachHandler::getByid)
                .andRoute(POST("/api/customer/post").and(accept(MediaType.APPLICATION_JSON)), coachHandler::postCoach)
                .andRoute(PUT("/api/customer/put/{id}").and(accept(MediaType.APPLICATION_JSON)), coachHandler::putCoach)
                .andRoute(DELETE("/api/customer/delete/{id}").and(accept(MediaType.APPLICATION_JSON)), coachHandler::deleteCoach);
    }

}
