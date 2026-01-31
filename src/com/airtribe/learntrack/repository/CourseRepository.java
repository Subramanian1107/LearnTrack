package com.airtribe.learntrack.repository;

import com.airtribe.learntrack.entity.Course;
import com.airtribe.learntrack.exception.EntityNotFoundException;

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
    public Course getCourseById(int id){
        for(Course course:courseList){
            if(course.getId() == id)
                return course;
        }
        throw new EntityNotFoundException(
                "Course not found with id: " + id
        );
    }
}
