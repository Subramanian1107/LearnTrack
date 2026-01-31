package com.airtribe.learntrack.entity;

public class Enrollment {
    private final int studentId;
    private final int courseId;
    private String status;
    public Enrollment(int studentId, int courseId){
        this.studentId = studentId;
        this.courseId = courseId;
        this.status = "ENROLLED";
    }

    public int getStudentId(){
        return studentId;
    }
    public int getCourseId(){
        return courseId;
    }
    public String getStatus(){
        return status;
    }
    public void setStatus(String status){
        this.status = status;
    }
    @Override
    public String toString() {
        return String.format(
                "StudentId: %d | CourseId: %d | Status: %s",
                studentId,
                courseId,
                status
        );
    }

}
