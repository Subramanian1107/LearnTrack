package com.airtribe.learntrack.repository;

import com.airtribe.learntrack.entity.Enrollment;

import java.util.ArrayList;
import java.util.List;

public class EnrollmentRepository {
    private final List<Enrollment> enrollments = new ArrayList<>();
    public void addEnrollment(Enrollment enrollment){

        enrollments.add(enrollment);
    }

    public List<Enrollment> getEnrollmentsByStudentId(int studentId){
        List<Enrollment> result = new ArrayList<>();
        for (Enrollment e : enrollments) {
            if (e.getStudentId() == studentId) {
                result.add(e);
            }
        }
        return result;
    }

    public Enrollment findEnrollment(int studentId, int courseId){
        for(Enrollment e: enrollments){
            if((e.getCourseId() == courseId) && (e.getStudentId() == studentId))
                return e;
        }
        return null;
    }

}
