package com.company.application.repositories;

import com.company.application.entities.Course;
import com.company.application.entities.CoursesEnrolled;
import com.company.application.entities.Student;
import com.company.application.repositories.jpa.CoursesEnrolledJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CourseEnrolledRepository {
    private final CoursesEnrolledJpaRepository repository;

    @Autowired
    public CourseEnrolledRepository(CoursesEnrolledJpaRepository repository) {
        this.repository = repository;
    }

    public void saveEnrolledCourse(CoursesEnrolled coursesEnrolled) {
        repository.save(coursesEnrolled);
    }

    public void removeCourseByStudentAndCourse(Student student, Course course) {
        repository.removeCourseByStudentAndCourse(student, course);
    }

    public List<CoursesEnrolled> coursesEnrolledByStudent(Student student) {
        return repository.coursesEnrolledByStudent(student);
    }
}
