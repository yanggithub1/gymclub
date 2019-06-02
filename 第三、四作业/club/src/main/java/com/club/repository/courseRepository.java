package com.club.repository;

import com.club.model.CourseEntity;
import com.club.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.domain.Pageable;
import org.springframework.web.reactive.function.server.ServerResponse;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.function.BiFunction;

@Repository
public interface courseRepository extends JpaRepository<CourseEntity, Integer> {
    @Transactional
    // 定义查询
    // @Param注解用于提取参数
    @Query("select c from CourseEntity c, CoachEntity h where c.coachName=:qName and h.coachName=:qName and h.coachLevel>2")
    public List<CourseEntity> getHigh(@Param("qName") String name);


    @Transactional
    // 定义查询
    // @Param注解用于提取参数
    @Query("select c from CourseEntity c where c.isPrivacy=1")
    public List<CourseEntity> get_Privacy();



}
