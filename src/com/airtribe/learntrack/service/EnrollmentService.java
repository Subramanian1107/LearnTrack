package com.airtribe.learntrack.service;

import com.airtribe.learntrack.repository.CourseRepository;
import com.airtribe.learntrack.repository.EnrollmentRepository;

import java.util.Scanner;

public class EnrollmentService {
    private final Scanner sc;
    private final EnrollmentRepository repository;

    public EnrollmentService(Scanner sc){
        this.sc = sc;
        this.repository = new EnrollmentRepository();
    }

    public void enrollmentMenu(){
        int choice;
        System.out.println("---Course Menu---");
        do{
            System.out.println("Enter choice");
            System.out.println("1. Add new enrollment");
            System.out.println("2. Display all enrollments for a student");
            System.out.println("3. Back");
            choice = sc.nextInt();
            switch (choice){
                case 1:
                    addEnrollment();
                    break;
                case 2:
                    findEnrollmentsForStudent();
                    break;
                case 3:
                    System.out.println("Returning back to main menu..");
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }while(choice!=3);
    }
    private void addEnrollment(){

    }
    private void findEnrollmentsForStudent(){

    }

}
