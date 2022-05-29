package com.company.application.services;

import com.company.application.entities.Course;
import com.company.application.entities.CoursesEnrolled;
import com.company.application.entities.Student;
import com.company.application.repositories.CourseEnrolledRepository;
import com.company.application.repositories.CourseRepository;
import com.company.application.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CourseService {
    private final CourseRepository courseRepository;
    private final CourseEnrolledRepository courseEnrolledRepository;
    private final StudentRepository studentRepository;

    @Autowired
    public CourseService(CourseRepository courseRepository, CourseEnrolledRepository courseEnrolledRepository,
                         StudentRepository studentRepository) {
        this.courseRepository = courseRepository;
        this.courseEnrolledRepository = courseEnrolledRepository;
        this.studentRepository = studentRepository;
    }

    @Transactional
    public List<Course> getCourses() {
        return courseRepository.getCourses();
    }

    @Transactional
    public void enrollCourse(Long studentId, Long courseId) {
        CoursesEnrolled coursesEnrolled = new CoursesEnrolled(studentRepository.getStudent(studentId), courseRepository.getCourse(courseId));
        courseEnrolledRepository.saveEnrolledCourse(coursesEnrolled);
    }

    @Transactional
    public void removeCourse(Long studentId, Long courseId) {
        courseEnrolledRepository.removeCourseByStudentAndCourse(studentRepository.getStudent(studentId), courseRepository.getCourse(courseId));
    }
}
