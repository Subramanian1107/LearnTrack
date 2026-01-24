package com.airtribe.learntrack.service;

import com.airtribe.learntrack.entity.Student;
import com.airtribe.learntrack.repository.StudentRepository;

import java.util.Scanner;

public class StudentService {
    private Scanner sc;
    private StudentRepository repository;
    public StudentService(Scanner sc){
        this.sc = sc;
        this.repository = new StudentRepository();
    }

    public void studentMenu(){
        int choice;

        System.out.println("\n=== Student Menu ===");
        do{
            System.out.print("Enter your choice: \n");
            System.out.println("1. Add new student");
            System.out.println("2. Display all students");
            System.out.println("3. Back");

            choice = sc.nextInt();
            switch(choice){
                case 1:
                    // Add student
                    addStudent();
                    break;
                case 2:
                    // Display all students
                    displayStudents();
                    break;
                case 3:
                    System.out.println("Returning back to main menu");
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }while(choice!=3);

    }
    private void addStudent(){
        System.out.println("Enter student id:");
        int id = sc.nextInt();
        System.out.println("Enter student name:");
        String name = sc.next();
        System.out.println("Enter student age:");
        int age = sc.nextInt();
        Student student = new Student(id,name,age);
        repository.addStudent(student);
        System.out.println("Student added successfully!");
    }
    private void displayStudents(){
        for(Student s : repository.getAllStudents()){
            System.out.println(s);
        }
    }
}
