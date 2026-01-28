package com.airtribe.learntrack.service;

import com.airtribe.learntrack.entity.Student;
import com.airtribe.learntrack.repository.StudentRepository;

import java.util.Scanner;

public class StudentService {
    private final Scanner sc;
    private final StudentRepository repository;
    public StudentService(Scanner sc, StudentRepository studentRepository){
        this.sc = sc;
        this.repository = studentRepository;
    }

    public void studentMenu(){
        int choice;

        System.out.println("\n=== Student Menu ===");
        do{
            System.out.print("Enter your choice: \n");
            System.out.println("1. Add new student");
            System.out.println("2. Display all students");
            System.out.println("3. Deactivate a student");
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
                    deactivateStudent();
                    break;
                case 4:
                    System.out.println("Returning back to main menu");
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }while(choice!=4);

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
            if(s.getStatus())
                System.out.println(s);
        }
    }
    private void deactivateStudent(){
        System.out.println("Enter student id:");
        int id  = sc.nextInt();
        Student student = repository.getStudentById(id);
        if(student == null){
            System.out.println("Student not found!");
            return;
        }
        student.setStatus(false);
        System.out.println("Deactivate student successfully!");
    }
}
