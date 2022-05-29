package com.company.application.entities.domain;

public class AddOrDropCourseRequest {
    private long studentId;
    private long courseId;

    public AddOrDropCourseRequest() {
    }

    public long getStudentId() {
        return studentId;
    }

    public void setStudentId(long studentId) {
        this.studentId = studentId;
    }

    public long getCourseId() {
        return courseId;
    }

    public void setCourseId(long courseId) {
        this.courseId = courseId;
    }

    @Override
    public String toString() {
        return "AddOrDropCourseRequest{" +
                "studentId=" + studentId +
                ", courseId=" + courseId +
                '}';
    }
}
