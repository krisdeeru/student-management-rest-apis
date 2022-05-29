package com.company.application.controllers;

import com.company.application.entities.Course;
import com.company.application.entities.Student;
import com.company.application.entities.domain.AddOrDropCourseRequest;
import com.company.application.entities.domain.CourseResponse;
import com.company.application.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/course")
public class CourseController {
    @Autowired
    private CourseService courseService;

    @GetMapping("/getCourses")
    @ResponseBody
    public CourseResponse listCourses() {
        List<Course> courses = courseService.getCourses();
        return new CourseResponse(courses);
    }

    @PostMapping("/addCourse")
    public ResponseEntity<Object> addCourse(@RequestBody AddOrDropCourseRequest request) {
        courseService.enrollCourse(request.getStudentId(), request.getCourseId());
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @PostMapping("/removeCourse")
    public ResponseEntity<Object> removeCourse(@RequestBody AddOrDropCourseRequest request) {
        courseService.removeCourse(request.getStudentId(), request.getCourseId());
        return new ResponseEntity<>(null, HttpStatus.OK);
    }
}
