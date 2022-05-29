package com.company.application.services;

import com.company.application.entities.Course;
import com.company.application.entities.CoursesEnrolled;
import com.company.application.entities.Student;
import com.company.application.entities.domain.StudentDetails;
import com.company.application.repositories.CourseEnrolledRepository;
import com.company.application.repositories.CourseRepository;
import com.company.application.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StudentService {
    private final StudentRepository studentRepository;
    private final CourseEnrolledRepository courseEnrolledRepository;
    private final CourseRepository courseRepository;
    
    @Autowired
    public StudentService(StudentRepository studentRepository, CourseEnrolledRepository courseEnrolledRepository,
                          CourseRepository courseRepository) {
        this.studentRepository = studentRepository;
        this.courseEnrolledRepository = courseEnrolledRepository;
        this.courseRepository = courseRepository;
    }

    @Transactional
    public List<Student> getStudents() {
        return studentRepository.getStudents();
    }

    @Transactional
    public void saveStudent(Student student) {
        studentRepository.saveStudent(student);
    }

    @Transactional
    public StudentDetails getStudentDetail(Long id) {
        Student student = studentRepository.getStudent(id);
        List<CoursesEnrolled> coursesEnrolled = courseEnrolledRepository.coursesEnrolledByStudent(student);
        return new StudentDetails(student, coursesEnrolled);
    }

    @Transactional
    public void deleteStudent(Long id) {
        studentRepository.deleteStudent(id);
    }
}
