package com.airtribe.learntrack.service;

import com.airtribe.learntrack.entity.Student;
import com.airtribe.learntrack.exception.InvalidInputException;
import com.airtribe.learntrack.repository.StudentRepository;
import com.airtribe.learntrack.util.InputValidator;

import java.util.Scanner;

public class StudentService {
    private final Scanner sc;
    private final StudentRepository repository;
    private final EnrollmentService enrollmentService;

    public StudentService(Scanner sc,
                          StudentRepository studentRepository,
                          EnrollmentService enrollmentService) {
        this.sc = sc;
        this.repository = studentRepository;
        this.enrollmentService = enrollmentService;
    }

    public void studentMenu(){
        int choice;

        System.out.println("\n=== Student Menu ===");
        do{
            System.out.print("Enter your choice: \n");
            System.out.println("1. Add new student");
            System.out.println("2. Display all students");
            System.out.println("3. Deactivate a student");
            System.out.println("4. Back");

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
        try{
            System.out.println("Enter student first name:");
            String firstName = sc.next();
            InputValidator.validateName(firstName);
            System.out.println("Enter student last name (or '-' to skip)::");
            String lastName = sc.next();
            if(lastName.equals("-"))    lastName = "";
            if(!lastName.isEmpty())
                InputValidator.validateName(lastName);
            System.out.println("Enter student email Id (or '-' to skip):");
            String email = sc.next();
            if(email.equals("-"))    email = "";
            if(!email.isEmpty())
                InputValidator.validateEmail(email);
            System.out.println("Enter batch:");
            int batch = sc.nextInt();
            InputValidator.validateBatch(batch);
            System.out.println("Enter student age:");
            int age = sc.nextInt();
            InputValidator.validateAge(age);
            Student student;
            if(lastName.isEmpty() && email.isEmpty())
                student = new Student(firstName,batch,age);
            else if(lastName.isEmpty())
                student = new Student(firstName,email,batch,age,true);
            else if(email.isEmpty())
                student = new Student(firstName,lastName,batch,age);
            else
                student = new Student(firstName,lastName,email,batch,age);
            repository.addStudent(student);
            System.out.println("Student added successfully!");
        }
        catch(InvalidInputException ex){
            System.out.println("Error: " + ex.getMessage());
        }

    }
    private void displayStudents(){
        System.out.println("Student details");
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
        enrollmentService.cancelEnrollmentsForStudent(id);
        System.out.println("Deactivated student successfully!");
    }
}
