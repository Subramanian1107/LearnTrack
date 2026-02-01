package com.airtribe.learntrack.entity;

public class Person {

    protected String firstName;
    protected String lastName;
    protected String email;
    protected int age;
    protected boolean active;

    public Person(String firstName,
                  String lastName,
                  String email,
                  int age) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.age = age;
        this.active = true;
    }

    public String getStudentFirstName() { return firstName; }
    public String getStudentLastName() { return lastName; }
    public String getStudentEmail() { return email; }
    public int getAge() { return age; }

    public boolean getStatus(){
        return active;
    }
    public void setStatus(boolean flag){
        active = flag;
    }
    public void display() {
        System.out.println(
                "Name: " + firstName + " " +
                        (lastName != null ? lastName : "") +
                        " | Age: " + age +
                        " | Email: " + (email != null ? email : "N/A")
        );
    }
}
