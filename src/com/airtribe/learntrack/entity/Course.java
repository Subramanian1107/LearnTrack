package com.airtribe.learntrack.entity;

public class Course {
    private final int courseId;
    private final String courseName;
    private boolean active;
    public Course(int courseId, String courseName){
        this.courseId = courseId;
        this.courseName = courseName;
        this.active = true;
    }
    public int getId(){
        return courseId;
    }
    public void setStatus(boolean flag){
        active = flag;
    }
    public boolean getStatus(){
        return active;
    }
    public String getName(){
        return courseName;
    }
    @Override
    public String toString(){
        return courseId + " " + courseName;
    }

}
