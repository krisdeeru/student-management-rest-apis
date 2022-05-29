package com.company.application.repositories;

import com.company.application.entities.Course;
import com.company.application.repositories.jpa.CourseJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CourseRepository {
    private final CourseJpaRepository repository;

    @Autowired
    public CourseRepository(CourseJpaRepository repository) {
        this.repository = repository;
    }

    public List<Course> getCourses() {
        return repository.findAll();
    }

    public Course getCourse(Long id) {
        return repository.findById(id).orElse(null);
    }
}
