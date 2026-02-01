package com.airtribe.learntrack.entity;

import com.airtribe.learntrack.util.IdGenerator;

public class Trainer extends Person{
    private final String courseName;
    private final int yearsOfExperience;
    private final int trainerId;
    private static final IdGenerator idGen = new IdGenerator();
    public Trainer(String firstName, String lastName, String email, String courseName, int yoe,int age){
        super(firstName,lastName,email,age);
        this.trainerId = idGen.getNextTrainerId();
        this.courseName = courseName;
        this.yearsOfExperience = yoe;
    }

    public String getCourseName() {
        return courseName;
    }
    public int getYearsOfExperience(){
        return yearsOfExperience;
    }
    @Override
    public void display(){
        System.out.println("ID: " + trainerId +
                " | First Name: " + super.firstName +
                " | Last Name: " + (super.lastName != null ? super.lastName : "N/A") +
                " | Email: " + (super.email != null ? super.email : "N/A") +
                " | Course taught: " + courseName +
                " | Years of experience: " + yearsOfExperience +
                " | Age: " + super.age);
    }
}
