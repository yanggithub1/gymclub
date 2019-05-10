package com.club.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "course", schema = "gym", catalog = "")
public class CourseEntity implements Serializable {
    private String courseName;
    private String duration;
    private String userName;
    private String coachName;
    private int courseId;

    @Basic
    @Column(name = "course_name", nullable = true, length = 20)
    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    @Basic
    @Column(name = "duration", nullable = true, length = 20)
    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    @Basic
    @Column(name = "user_name", nullable = true, length = 20)
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Basic
    @Column(name = "coach_name", nullable = true, length = 20)
    public String getCoachName() {
        return coachName;
    }

    public void setCoachName(String coachName) {
        this.coachName = coachName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CourseEntity that = (CourseEntity) o;
        return Objects.equals(courseName, that.courseName) &&
                Objects.equals(duration, that.duration) &&
                Objects.equals(userName, that.userName) &&
                Objects.equals(coachName, that.coachName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(courseName, duration, userName, coachName);
    }


    @Id
    @Column(name = "course_id", nullable = false)
    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }
}
