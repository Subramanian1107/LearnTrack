package com.airtribe.learntrack.entity;

public class Trainer extends Person{
    private final String courseName;
    private final int yearsOfExperience;
    public Trainer(String firstName, String lastName, String email, String courseName, int yoe,int age){
        super(firstName,lastName,email,age);
        this.courseName = courseName;
        this.yearsOfExperience = yoe;
    }

    public String getCourseName() {
        return courseName;
    }
    public int getYearsOfExperience(){
        return yearsOfExperience;
    }
}
