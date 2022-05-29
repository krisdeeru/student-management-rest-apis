package com.company.application.entities.domain;

import com.company.application.entities.Student;

import java.util.List;

public class StudentsResponse {
    private List<Student> students;

    public StudentsResponse() {
    }

    public StudentsResponse(List<Student> students) {
        this.students = students;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "StudentsResponse{" +
                "students=" + students +
                '}';
    }
}
