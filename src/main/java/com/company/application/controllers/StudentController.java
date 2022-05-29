package com.company.application.controllers;

import com.company.application.entities.Student;
import com.company.application.entities.domain.SaveStudentDetailsBody;
import com.company.application.entities.domain.StudentDetails;
import com.company.application.entities.domain.StudentsResponse;
import com.company.application.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/getStudents")
    @ResponseBody
    public StudentsResponse listStudents() {
        List<Student> students = studentService.getStudents();
        return new StudentsResponse(students);
    }

    @PostMapping("/saveStudent")
    public ResponseEntity<Object> saveStudent(@RequestBody SaveStudentDetailsBody saveStudentDetailsBody) {
        Student student = new Student(saveStudentDetailsBody.getFirstName(), saveStudentDetailsBody.getLastName(), saveStudentDetailsBody.getEmail());
        studentService.saveStudent(student);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @PostMapping("/updateStudent")
    public ResponseEntity<Object> updateStudent(@RequestBody Student student) {
        studentService.saveStudent(student);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @DeleteMapping("/deleteStudent/{studentId}")
    public ResponseEntity<Object> deleteStudent(@PathVariable Long studentId) {
        studentService.deleteStudent(studentId);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @GetMapping("/getStudentDetail/{studentId}")
    @ResponseBody
    public StudentDetails studentDetails(@PathVariable Long studentId) {
        return studentService.getStudentDetail(studentId);
    }
}
