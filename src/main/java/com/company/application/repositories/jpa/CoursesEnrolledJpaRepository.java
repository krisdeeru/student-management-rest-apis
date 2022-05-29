package com.company.application.repositories.jpa;

import com.company.application.entities.Course;
import com.company.application.entities.CoursesEnrolled;
import com.company.application.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CoursesEnrolledJpaRepository extends JpaRepository<CoursesEnrolled, Long> {
    @Query("FROM CoursesEnrolled WHERE student = :student")
    List<CoursesEnrolled> coursesEnrolledByStudent(@Param("student") Student student);

    @Modifying
    @Query("DELETE FROM CoursesEnrolled WHERE student = :student AND course = :course")
    void removeCourseByStudentAndCourse(@Param("student") Student student, @Param("course") Course course);
}
