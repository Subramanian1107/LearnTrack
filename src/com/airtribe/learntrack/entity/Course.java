package com.airtribe.learntrack.entity;

public class Course {
    private final int courseId;
    private final String courseName;

    public Course(int courseId, String courseName){
        this.courseId = courseId;
        this.courseName = courseName;
    }
    public int getId(){
        return courseId;
    }
    public String getName(){
        return courseName;
    }
    @Override
    public String toString(){
        return courseId + " " + courseName;
    }

}
