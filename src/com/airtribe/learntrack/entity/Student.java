package com.airtribe.learntrack.entity;

import com.airtribe.learntrack.util.IdGenerator;

public class Student extends Person {
    private final int studentId;
    private final int batch;
    private static final IdGenerator idGen = new IdGenerator();
    // Main constructor
    public Student(String firstName,
                   String lastName,
                   String email,
                   int batch,
                   int age) {

        super(firstName, lastName, email, age);

        this.studentId = idGen.getNextStudentId();
        this.batch = batch;
    }

    // No email
    public Student(String firstName, String lastName,
                   int batch, int age) {
        this(firstName, lastName, null, batch, age);
    }

    // Only first name
    public Student(String firstName, int batch, int age) {
        this(firstName, null, null, batch, age);
    }

    public Student(String firstName, String email, int batch, int age, boolean emailOnly){
        this(firstName,null,email,batch,age);
    }


    public int getId(){
        return studentId;
    }
    public int getBatch(){return batch;}

    @Override
    public String toString() {
        return "ID: " + studentId +
                " | First Name: " + super.firstName +
                " | Last Name: " + (super.lastName != null ? super.lastName : "N/A") +
                " | Email: " + (super.email != null ? super.email : "N/A") +
                " | Batch: " + batch +
                " | Age: " + super.age;
    }

}
