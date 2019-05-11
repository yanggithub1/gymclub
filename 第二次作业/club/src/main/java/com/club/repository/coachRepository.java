package com.club.repository;

import com.club.model.CoachEntity;
import com.club.model.CourseEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.query.Param;

import javax.persistence.QueryHint;

import java.awt.print.Pageable;

import static org.hibernate.jpa.QueryHints.HINT_COMMENT;

public interface coachRepository extends JpaRepository<CoachEntity, Integer> {
}
