package com.company.application.entities.domain;

import com.company.application.entities.CoursesEnrolled;
import com.company.application.entities.Student;

import java.util.List;

public class StudentDetails {
    Student student;
    List<CoursesEnrolled> coursesEnrolled;

    public StudentDetails() {
    }

    public StudentDetails(Student student, List<CoursesEnrolled> coursesEnrolled) {
        this.student = student;
        this.coursesEnrolled = coursesEnrolled;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public List<CoursesEnrolled> getCoursesEnrolled() {
        return coursesEnrolled;
    }

    public void setCoursesEnrolled(List<CoursesEnrolled> coursesEnrolled) {
        this.coursesEnrolled = coursesEnrolled;
    }

    @Override
    public String toString() {
        return "StudentDetails{" +
                "student=" + student +
                ", coursesEnrolled=" + coursesEnrolled +
                '}';
    }
}
