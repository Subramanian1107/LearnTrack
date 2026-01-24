package com.airtribe.learntrack.entity;

public class Student {
    private final int studentId;
    private final String studentName;
    private final int studentAge;
    public Student(int studentId, String studentName, int studentAge){
        this.studentId = studentId;
        this.studentName = studentName;
        this.studentAge = studentAge;
    }

    public int getId(){
        return studentId;
    }
    public String getName(){
        return studentName;
    }
    public int getAge(){
        return studentAge;
    }

    @Override
    public String toString(){
        return studentId + "-" + studentName + "-" + studentAge;
    }


}
