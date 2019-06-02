package com.club.model;

public class course {
    private String course_name;
    private String course_duration;

    public course(String course_name, String course_duration) {
        this.course_name = course_name;
        this.course_duration = course_duration;
    }

    public String getCourse_name() {
        return this.course_name;
    }

    public String getCourse_duration() {
        return this.course_duration;
    }


}
