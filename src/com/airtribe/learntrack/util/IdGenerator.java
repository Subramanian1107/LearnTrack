package com.airtribe.learntrack.util;

public class IdGenerator {
    private static int studentIdCounter = 0;
    private static int courseIdCounter = 0;
    public int getNextStudentId(){
        studentIdCounter++;
        return studentIdCounter;
    }
    public int getNextCourseId(){
        courseIdCounter++;
        return courseIdCounter;
    }

}
