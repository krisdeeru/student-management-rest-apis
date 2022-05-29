package com.company.application.repositories.jpa;

import com.company.application.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseJpaRepository extends JpaRepository<Course, Long> {
}
