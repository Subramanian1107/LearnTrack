package com.airtribe.learntrack.repository;

import com.airtribe.learntrack.entity.Course;

import java.util.ArrayList;
import java.util.List;

public class CourseRepository {
    private final List<Course> courseList = new ArrayList<>();

    public void addCourse(Course course){
        courseList.add(course);
    }
    public List<Course> getAllCourses(){
        return courseList;
    }
}
