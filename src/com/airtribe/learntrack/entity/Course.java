package com.airtribe.learntrack.entity;

import com.airtribe.learntrack.util.IdGenerator;

public class Course {
    private final int courseId;
    private final String courseName;
    private boolean active;
    private final String courseDescription;
    private final int courseDurationInWeeks;
    private static final IdGenerator idGen = new IdGenerator();
    public Course(String courseName, String courseDescription, int courseDurationInWeeks){
        this.courseId = idGen.getNextCourseId();
        this.courseName = courseName;
        this.courseDescription = courseDescription;
        this.courseDurationInWeeks = courseDurationInWeeks;
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

    public int getCourseDurationInWeeks() {
        return courseDurationInWeeks;
    }
    public String getCourseDescription(){
        return courseDescription;
    }

    public String getName(){
        return courseName;
    }
    @Override
    public String toString() {
        return String.format(
                "CourseId: %d | Name: %s | Description: %s | Duration: %d weeks",
                courseId,
                courseName,
                courseDescription,
                courseDurationInWeeks
        );
    }


}
