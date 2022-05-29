package com.company.application.entities.domain;

import com.company.application.entities.Course;

import java.util.List;

public class CourseResponse {
    private List<Course> courses;

    public CourseResponse() {
    }

    public CourseResponse(List<Course> courses) {
        this.courses = courses;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    @Override
    public String toString() {
        return "CourseResponse{" +
                "courses=" + courses +
                '}';
    }
}
